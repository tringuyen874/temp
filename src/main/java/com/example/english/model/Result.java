package com.example.english.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "result")
public class Result {
    @Id
    @Column(name = "rs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int resultId;

    @Column(name = "us_id")
    int userId;

    @Column(name = "ex_id")
    int examId;

    

    @Column(name = "rs_score")
    int resultScore;

    @Column(name = "rs_datetime", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    LocalDateTime  resultDatetime;

    @Column(name = "rs_flag")
    int resultFlag;

    @Column(name = "rs_type")
    int resultType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wd_id", referencedColumnName = "wd_id")
    private Word word;

    public void assignWord(Word wordToAssign) {
        this.word = wordToAssign;
    }

    public int getResultId() {
        return resultId;
    }

    public int getUserId() {
        return userId;
    }

    public int getExamId() {
        return examId;
    }

   

    public int getResultScore() {
        return resultScore;
    }

    public LocalDateTime  getResultDatetime() {
        return resultDatetime;
    }

    public int getResultFlag() {
        return resultFlag;
    }

    public int getResultType() {
        return resultType;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

   

    public void setResultScore(int resultScore) {
        this.resultScore = resultScore;
    }

    public void setResultDatetime(LocalDateTime  resultDatetime) {
        this.resultDatetime = resultDatetime;
    }

    public void setResultFlag(int resultFlag) {
        this.resultFlag = resultFlag;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Result [resultId=" + resultId + ", userId=" + userId + ", examId=" + examId + 
         ", resultScore=" + resultScore + ", resultDatetime=" + resultDatetime + ", resultFlag=" + resultFlag
        + ", resultType=" + resultType + "]";
    }

    public Result() {
    }

    public Result(int userId, int examId, int resultScore, LocalDateTime resultDatetime, int resultFlag,
            int resultType) {
        this.userId = userId;
        this.examId = examId;
        this.resultScore = resultScore;
        this.resultDatetime = resultDatetime;
        this.resultFlag = resultFlag;
        this.resultType = resultType;
    }

    
}
