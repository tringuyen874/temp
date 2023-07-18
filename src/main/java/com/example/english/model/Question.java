package com.example.english.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "qs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int questionId;

    @Column(name = "qs_content")
    String questionContent;

    @Column(name = "qs_answer")
    int questionAnswer;

    @Column(name = "topic_id")
    int topicId;

    @Column(name = "qs_option1")
    String questionOption1;

    @Column(name = "qs_option2")
    String questionOption2;

    @Column(name = "qs_option3")
    String questionOption3;

    @Column(name = "qs_option4")
    String questionOption4;

    @Column(name = "qs_explain")
    String questionExplain;

    @Column(name = "qs_type")
    int questionType;

    @Column(name = "lv_id")
    int levelId;

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public int getQuestionAnswer() {
        return questionAnswer;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getQuestionOption1() {
        return questionOption1;
    }

    public String getQuestionOption2() {
        return questionOption2;
    }

    public String getQuestionOption3() {
        return questionOption3;
    }

    public String getQuestionOption4() {
        return questionOption4;
    }

    public String getQuestionExplain() {
        return questionExplain;
    }

    public int getQuestionType() {
        return questionType;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public void setQuestionAnswer(int questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setQuestionOption1(String questionOption1) {
        this.questionOption1 = questionOption1;
    }

    public void setQuestionOption2(String questionOption2) {
        this.questionOption2 = questionOption2;
    }

    public void setQuestionOption3(String questionOption3) {
        this.questionOption3 = questionOption3;
    }

    public void setQuestionOption4(String questionOption4) {
        this.questionOption4 = questionOption4;
    }

    public void setQuestionExplain(String questionExplain) {
        this.questionExplain = questionExplain;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public Question( String questionContent, int questionAnswer, int topicId, String questionOption1,
            String questionOption2, String questionOption3, String questionOption4, String questionExplain,
            int questionType, int levelId) {
        this.questionContent = questionContent;
        this.questionAnswer = questionAnswer;
        this.topicId = topicId;
        this.questionOption1 = questionOption1;
        this.questionOption2 = questionOption2;
        this.questionOption3 = questionOption3;
        this.questionOption4 = questionOption4;
        this.questionExplain = questionExplain;
        this.questionType = questionType;
        this.levelId = levelId;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", questionContent=" + questionContent + ", questionAnswer="
                + questionAnswer + ", topicId=" + topicId + ", questionOption1=" + questionOption1
                + ", questionOption2=" + questionOption2 + ", questionOption3=" + questionOption3 + ", questionOption4="
                + questionOption4 + ", questionExplain=" + questionExplain + ", questionType=" + questionType
                + ", levelId=" + levelId + "]";
    }

    
}
