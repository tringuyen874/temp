package com.example.english.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.english.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{
    
}
