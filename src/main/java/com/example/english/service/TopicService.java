package com.example.english.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.Topic;
import com.example.english.respository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }
    
    public Topic getTopic(int id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
