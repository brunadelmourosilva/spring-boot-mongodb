package com.brunadelmouro.springmongodb.services;

import com.brunadelmouro.springmongodb.domain.User;
import com.brunadelmouro.springmongodb.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll(){
        return userRespository.findAll();
    }
}
