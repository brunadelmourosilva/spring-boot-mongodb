package com.brunadelmouro.springmongodb.services;

import com.brunadelmouro.springmongodb.domain.User;
import com.brunadelmouro.springmongodb.dto.UserDTO;
import com.brunadelmouro.springmongodb.repository.UserRespository;
import com.brunadelmouro.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll() {
        return userRespository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRespository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User insert(User obj) {
        return userRespository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}