package com.example.english.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Transactional
@Data
@Table(name = "log")
public class Log {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int logId;
    
    @Column(name = "us_id")
    int userId;

    @Column(name = "log_action")
    String logAction;

    @Column(name = "log_datetime", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    LocalDateTime logDatetime;

    @Column(name = "log_status")
    int logStatus;

    public int getLogId() {
        return logId;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogAction() {
        return logAction;
    }

    public LocalDateTime  getLogDatetime() {
        return logDatetime;
    }

    public int getLogStatus() {
        return logStatus;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public void setLogDatetime(LocalDateTime  logDatetime) {
        this.logDatetime = logDatetime;
    }

    public void setLogStatus(int logStatus) {
        this.logStatus = logStatus;
    }

    @Override
    public String toString() {
        return "Log [logId=" + logId + ", userId=" + userId + ", logAction=" + logAction + ", logDatetime="
                + logDatetime + ", logStatus=" + logStatus + "]";
    }

    public Log() {
    }

    public Log(int userId, String logAction, LocalDateTime logDatetime, int logStatus) {
        this.userId = userId;
        this.logAction = logAction;
        this.logDatetime = logDatetime;
        this.logStatus = logStatus;
    }

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // private User user;
}
