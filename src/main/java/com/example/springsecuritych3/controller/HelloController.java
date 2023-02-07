package com.example.springsecuritych3.controller;

import com.example.springsecuritych3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        Assert.hasText(user.getUsername(), "Username may not be empty or null");
        userDetailsManager.createUser(user);
    }
}
