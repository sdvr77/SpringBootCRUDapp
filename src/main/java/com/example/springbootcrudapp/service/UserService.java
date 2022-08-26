package com.example.springbootcrudapp.service;

import com.example.springbootcrudapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    void deleteById(int id);
}