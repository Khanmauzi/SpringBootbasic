package com.example.demo.hello;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    public String greeting;
    public String name = "System";
    public void setGreeting(String s) {
        this.greeting = s;
    }
    public void  setName(String s){
        greeting = "Welcome";
        this.name = s;
    }

}
