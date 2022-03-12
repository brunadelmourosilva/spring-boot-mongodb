package com.brunadelmouro.springmongodb.config;

import com.brunadelmouro.springmongodb.domain.User;
import com.brunadelmouro.springmongodb.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRespository userRespository;

    @Override
    public void run(String... args) throws Exception {

        userRespository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bruna = new User(null, "Bruna Grey", "bruna@gmail.com");

        userRespository.saveAll(Arrays.asList(maria, alex, bruna));

    }
}
