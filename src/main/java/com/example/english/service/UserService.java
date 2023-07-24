package com.example.english.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.email.EmailService;
import com.example.english.model.User;
import com.example.english.registration.token.ConfirmationToken;
import com.example.english.registration.token.ConfirmationTokenService;
import com.example.english.respository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailService emailService;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findByUsername(user.getUsername()).isPresent();
        boolean emailExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExists) {
            throw new IllegalStateException("user already exists");
        }
        if (emailExists) {
            throw new IllegalStateException("email already exists");
        }
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // String link = "http://localhost:8080/tokens/confirm?token=" + token;
        // String to =  emailService.buildEmail(user.getUsername(), link);
        // emailService.send(user.getEmail(), to);
        
        return token;
    }
    public void enableUser(String email) {
        userRepository.enableUser(email);
    }
}
