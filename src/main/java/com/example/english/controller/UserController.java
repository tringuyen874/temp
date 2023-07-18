package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Log;
import com.example.english.model.User;
import com.example.english.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findUser(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}/logs")
    public List<Log> findUserLogs(@PathVariable int id) {
        User user = userService.findUser(id);
        List<Log> logs = user.getLogs();
        return logs;
    }
}
