package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.ExamTopic;
import com.example.english.service.ExamTopicService;

@RestController
public class ExamTopicController {
    @Autowired
    private ExamTopicService ExamTopicService;

    @GetMapping("/examTopics")
    public List<ExamTopic> getTopics() {
        return ExamTopicService.getExamTopics();
    }
    
    @GetMapping("/examTopics/{id}")
    public ExamTopic getTopic(@PathVariable int id) {
        return ExamTopicService.getExamTopic(id);
    }

    @PostMapping("/examTopics")
    public ExamTopic addTopic(@RequestBody ExamTopic topic) {
        return ExamTopicService.addExamTopic(topic);
    }

    @DeleteMapping("/examTopics/{id}")
    public void deleteTopic(@PathVariable int id) {
        ExamTopicService.deleteExamTopic(id);
    }

    @PostMapping("/examTopics/{topic_id}/topics")
    public int addTopicToExamTopic(@PathVariable int topic_id, @RequestBody ExamTopic examTopic) {
        return ExamTopicService.addTopicToExamTopic(topic_id, examTopic);
    }
}
