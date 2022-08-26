package com.example.springbootcrudapp.controller;

import com.example.springbootcrudapp.model.User;
import com.example.springbootcrudapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/addUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "newUserInfo";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        return "updateUserInfo";
    }
    @GetMapping("/delete")
    public String deleteUserbyId(@ModelAttribute("user") User user) {
        userService.deleteById(user.getId());
        return "redirect:/";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) {
        return "deleteUser";
    }
}

