package com.example.english.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.english.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer>{
    
}
