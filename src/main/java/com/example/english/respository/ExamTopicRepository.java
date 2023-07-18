package com.example.english.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.english.model.ExamTopic;

public interface ExamTopicRepository extends JpaRepository<ExamTopic, Integer>{
    
}
