package com.brunadelmouro.springmongodb.resources;

import com.brunadelmouro.springmongodb.domain.Post;
import com.brunadelmouro.springmongodb.resources.util.URL;
import com.brunadelmouro.springmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> posts = postService.findByTitle(text);

        return ResponseEntity.ok().body(posts);
    }
}
