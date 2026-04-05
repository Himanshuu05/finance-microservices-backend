package com.himanshu.user_service.controller;

import com.himanshu.user_service.model.Users;
import com.himanshu.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public Users create(@RequestBody Users user) {
        return service.createUser(user);
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return service.getAllUsers();
    }
}