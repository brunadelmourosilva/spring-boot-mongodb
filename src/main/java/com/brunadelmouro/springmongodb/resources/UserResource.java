package com.brunadelmouro.springmongodb.resources;


import com.brunadelmouro.springmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = new ArrayList<>();

        User user1 = new User("1001", "Bruna", "brunadelmouro@gmail.com");
        User user2 = new User("1002", "Alex", "alex.rodrigues@gmail.com");

        users.addAll(Arrays.asList(user1, user2));

        return ResponseEntity.ok().body(users);
    }
}
