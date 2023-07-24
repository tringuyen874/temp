package com.example.english.service;

import java.util.function.Predicate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

// @Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {

    private EmailValidator emailValidator;
    @Override
    public boolean test(String t) {
        
        // TODO Auto-generated method stub
        return true;
    }

    public String register(HttpServletRequest request) {
        boolean isValidEmail = emailValidator.test(request.getParameter("email"));
        if(!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return "works";
    }
    
}
