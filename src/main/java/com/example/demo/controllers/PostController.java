package com.example.demo.controllers;

import com.example.demo.entities.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/user/{id}/posts")
    public List<Post>getUserPosts(@PathVariable int id) {
        return postService.getAllPost(id);

    }
    @PostMapping("/user/{id}/post")
    public ResponseEntity<Object> addUserPost(@PathVariable int id, @RequestBody Post post){
        return postService.addPost(id,post);
    }
}
