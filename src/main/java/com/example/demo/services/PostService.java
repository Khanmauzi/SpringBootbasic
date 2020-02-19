package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Post>getAllPost(int id) throws UserNotFoundException {
        Optional<User>user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("ID- "+ id );
        }
        return user.get().getPost();
    }

    public ResponseEntity<Object> addPost(int id, Post post) throws  UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("Id- "+id);
        }
        User userdata = user.get();
        post.setUser(userdata);
        try {
            postRepository.save(post);
        } catch (Exception e){
            throw e;
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("s")
                .buildAndExpand().toUri();

        return ResponseEntity.created(location).build();

    }


}
