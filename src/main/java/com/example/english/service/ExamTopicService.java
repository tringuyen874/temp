package com.example.english.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.ExamTopic;
import com.example.english.model.Topic;
import com.example.english.respository.ExamTopicRepository;

@Service
public class ExamTopicService {
    @Autowired
    private ExamTopicRepository examTopicRepository;

    @Autowired
    private TopicService topicService;

    public ExamTopicService(ExamTopicRepository examtopicRepository) {
        this.examTopicRepository = examtopicRepository;
    }

    public List<ExamTopic> getExamTopics() {
        return examTopicRepository.findAll();
    }
    
    public ExamTopic getExamTopic(int id) {
        return examTopicRepository.findById(id).orElse(null);
    }

    public ExamTopic addExamTopic(ExamTopic examtopic) {
        return examTopicRepository.save(examtopic);
    }

    public void deleteExamTopic(int id) {
        examTopicRepository.deleteById(id);
    }

    public void updateexamTopic(ExamTopic examtopic) {
        examTopicRepository.save(examtopic);
    }

    public int addTopicToExamTopic(int topic_id, ExamTopic examTopic) {
        Topic topic = topicService.getTopic(topic_id);
        examTopic.setTopicId(topic_id);
        examTopic.setTopic(topic);
        topic.getExamTopics().add(examTopic);
        topicService.updateTopic(topic);
        return 1;
    }
}
