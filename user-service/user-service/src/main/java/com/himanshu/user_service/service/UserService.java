package com.himanshu.user_service.service;

import com.himanshu.user_service.model.Users;
import com.himanshu.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public Users createUser(Users user) {
        return repo.save(user);
    }

    public List<Users> getAllUsers() {
        return repo.findAll();
    }
}
