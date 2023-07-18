package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Topic;
import com.example.english.service.TopicService;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }
    
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable int id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable("id") int id) {
        topicService.deleteTopic(id);
    }
}
