package com.example.demo.controllers;

import com.example.demo.hello.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    Hello hello;

    @Autowired
    private MessageSource messageSource;
    @GetMapping("")
    public  String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/bean")
    public Hello helloBean() {
        hello.setGreeting("Hellow bean");
        return hello;
    }

    @GetMapping("/bean/{name}")
    public Hello helloName(@PathVariable("name") String name){
        hello.setName(name);
        return hello;
    }
    /**
     * Implementing Internationalization
     *
     * */
//    @GetMapping("/goodMorming")
//    public String helloWorldInternationlization(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
//        //return "Hello! Good Morning";
//        return messageSource.getMessage("good.morning.message",null, locale);
//    }

    /**
     * here we are not accepting Locale as header parameter but letting localecontextholder to get it.
     * it is simplified version of above
     * @return
     */
    @GetMapping("/goodMorming")
    public String helloWorldInternationlization(){
        //return "Hello! Good Morning";
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
