package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;
//    private static List<User> users = new ArrayList<>();
//    private static int usersCount = 3;
//    static {
//        users.add(new User(1,"Mauzi", new Date()));
//        users.add(new User(2,"Tipu", new Date()));
//        users.add(new User(3,"Manish", new Date()));
//    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(int id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void deleteUserbyId(int id) {
      userRepository.deleteById(id);
    }
}
