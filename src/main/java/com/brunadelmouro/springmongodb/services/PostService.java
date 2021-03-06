package com.brunadelmouro.springmongodb.services;

import com.brunadelmouro.springmongodb.domain.Post;
import com.brunadelmouro.springmongodb.domain.User;
import com.brunadelmouro.springmongodb.dto.UserDTO;
import com.brunadelmouro.springmongodb.repository.PostRespository;
import com.brunadelmouro.springmongodb.repository.UserRespository;
import com.brunadelmouro.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRespository postRespository;


    public Post findById(String id) {
        Optional<Post> obj = postRespository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findByTitle(String text){
        //return postRespository.findByTitleContainingIgnoreCase(text);
        return postRespository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

        return postRespository.fullSearch(text, minDate, maxDate);
    }

}