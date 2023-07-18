package com.example.english.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Data
@Table(name = "topic")
public class Topic {
    @Id
    @Column(name = "tp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int topicId;

    @Column(name = "tp_name")
    String topicName;

    @Column(name = "tp_description")
    String topicDescription;

    public int getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    @Override
    public String toString() {
        return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicDescription=" + topicDescription
                + "]";
    }

    public Topic(String topicName, String topicDescription) {
        this.topicName = topicName;
        this.topicDescription = topicDescription;
    }

    public Topic() {
    }

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<ExamTopic> examTopics;
    
}
