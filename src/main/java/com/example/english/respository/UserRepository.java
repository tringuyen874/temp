package com.example.english.respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.english.model.User;

// @Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
