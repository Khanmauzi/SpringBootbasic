package com.example.demo.controllers;

import com.example.demo.versionings.Name;
import com.example.demo.versionings.Person1;
import com.example.demo.versionings.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versions")
public class VersioningController {

    @GetMapping(value="/person", params = "version=1")
    public Person1 getPerso1() {
        return new Person1("Mauzi Khan");
    }

    @GetMapping(value="/person", params = "version=2")
    public Person2 getPerson2() {
        return new Person2(new Name("Mauz", "khan"));
    }
}
