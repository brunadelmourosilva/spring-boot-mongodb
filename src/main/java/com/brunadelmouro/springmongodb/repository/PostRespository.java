package com.brunadelmouro.springmongodb.repository;

import com.brunadelmouro.springmongodb.domain.Post;
import com.brunadelmouro.springmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRespository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
