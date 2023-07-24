package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.english.model.User;
import com.example.english.registration.RegistrationService;
import com.example.english.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationService registrationService;

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

    @GetMapping("/users/showForm")
    public String showForm() {
        return "test";
    }

    @PostMapping("/submitForm")
    public String submitForm(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        int status = Integer.parseInt(request.getParameter("status"));
        User user = new User(username, password, fullname, email, phone, address, groupId, status);
        registrationService.register(user);
        
        
        return "redirect:/users/showForm";
    }

    // @GetMapping("/users/confirm")
    // public String confirm(@RequestParam("token") String token) {
    //     return confirmationTokenService.confirmToken(token);
    // }
    
}
