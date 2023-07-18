package com.example.english.model;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "ex_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int examId;

    @Column(name = "ex_question_no")
    int examQuestionNo;

    @Column(name = "ex_time", columnDefinition = "DATETIME")
    LocalDateTime  examTime;

    @Column(name = "lv_id")
    int levelId;

    public int getExamId() {
        return examId;
    }

    public int getExamQuestionNo() {
        return examQuestionNo;
    }

    public LocalDateTime getExamTime() {
        return examTime;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setExamQuestionNo(int examQuestionNo) {
        this.examQuestionNo = examQuestionNo;
    }

    public void setExamTime(LocalDateTime examTime) {
        this.examTime = examTime;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", examQuestionNo=" + examQuestionNo + ", examTime=" + examTime + ", levelId="
                + levelId + "]";
    }

    public Exam(int examQuestionNo, LocalDateTime examTime, int levelId) {
        this.examQuestionNo = examQuestionNo;
        this.examTime = examTime;
        this.levelId = levelId;
    }

    

}
