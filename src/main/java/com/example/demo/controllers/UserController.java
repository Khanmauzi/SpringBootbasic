package com.example.demo.controllers;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.UserService;
import com.example.demo.entities.User;
import lombok.extern.slf4j.Slf4j;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User>getAllUser(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<Object> postUserData(@Valid @RequestBody User user ){
        User userCreated = userService.saveUser(user);

        /**
         * Here we are returning the access locatino/url for the new created User
         */

        // user/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId()).toUri();

        return ResponseEntity.created(location).build();
   }

    @GetMapping("/user/{id}")
    public Optional<User> getUserDetails(@PathVariable int id) {
        Optional<User> user =  userService.getUser(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("id - "+id);
        }
        //HATEOAS
        //"all-users", SERVER_PATH+ "/users"
        /**
        * Here We are implementing HATEAOS
         * Return link of all user access
        * */

//        Resource<User> resource = new Resource<User>(user);
//        ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).getAllUser());
//        resource.add(linkto.withRel("all-users"));
        return user;
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUserbyId(id);
    }

}
