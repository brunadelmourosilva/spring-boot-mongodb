package com.brunadelmouro.springmongodb.repository;

import com.brunadelmouro.springmongodb.domain.Post;
import com.brunadelmouro.springmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends MongoRepository<Post, String> {
}
