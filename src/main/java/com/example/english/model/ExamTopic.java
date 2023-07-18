package com.example.english.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Data
@Table(name = "exam_topic")
public class ExamTopic {
    @Id
    @Column(name = "et_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int examTopicId;

    @Column(name = "ex_id")
    int examId;

    @Column(name = "tp_id")
    int topicId;

    @Column(name = "et_topic_percent")
    int examTopicPercent;

    public int getExamTopicId() {
        return examTopicId;
    }

    public int getExamId() {
        return examId;
    }

    public int getTopicId() {
        return topicId;
    }

    public int getExamTopicPercent() {
        return examTopicPercent;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setExamTopicPercent(int examTopicPercent) {
        this.examTopicPercent = examTopicPercent;
    }

    public ExamTopic( int examId, int topicId, int examTopicPercent) {
        this.examId = examId;
        this.topicId = topicId;
        this.examTopicPercent = examTopicPercent;
    }

    @Override
    public String toString() {
        return "ExamTopic [examTopicId=" + examTopicId + ", examId=" + examId + ", topicId=" + topicId
                + ", examTopicPercent=" + examTopicPercent + "]";
    }

    public ExamTopic() {
    }

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Topic topic;
}
