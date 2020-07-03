package com.example.demo.user.controller;

import com.example.demo.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final List<User> USERS = new ArrayList<>(List.of(
            new User(1L, "Alex"),
            new User(2L, "Jim"),
            new User(3L, "Bob")
    ));

    @GetMapping
    public List<User> findAll() {
        return USERS;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PostMapping
    public void create(@RequestBody User user) {
        USERS.add(user);
    }
}
