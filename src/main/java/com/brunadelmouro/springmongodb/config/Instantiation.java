package com.brunadelmouro.springmongodb.config;

import com.brunadelmouro.springmongodb.domain.Post;
import com.brunadelmouro.springmongodb.domain.User;
import com.brunadelmouro.springmongodb.dto.AuthorDTO;
import com.brunadelmouro.springmongodb.dto.CommentDTO;
import com.brunadelmouro.springmongodb.repository.PostRespository;
import com.brunadelmouro.springmongodb.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRespository userRespository;

    @Autowired
    PostRespository postRespository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        userRespository.deleteAll();
        postRespository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bruna = new User(null, "Bruna Grey", "bruna@gmail.com");

        userRespository.saveAll(Arrays.asList(maria, alex, bruna));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bruna));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRespository.saveAll(Arrays.asList(post1, post2));

        //associação dos posts
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRespository.save(maria);
    }
}
