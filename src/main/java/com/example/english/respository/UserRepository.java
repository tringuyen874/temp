package com.example.english.respository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.english.model.User;


// @Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM user WHERE us_username = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE us_email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET u.us_enabled = TRUE WHERE u.us_email = ?1", nativeQuery = true)
    void enableUser(String email);
}
