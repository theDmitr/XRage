package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRest {
    List<User> users = new ArrayList<>();
    private User user;
    @GetMapping
    public User getUser(){
        return user;
    }
    @GetMapping
    public List<User> getUsers(){
        return users;
    }
    @PostMapping
    public User postUser(@RequestParam User user){
        this.user = user;
        return user;
    }
}
