package com.example.english.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.english.model.Word;

public interface WordRepository extends JpaRepository<Word, Integer>{
    
}
