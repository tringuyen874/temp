package com.example.english.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.Log;
import com.example.english.model.User;
import com.example.english.respository.LogRepository;
import com.example.english.respository.UserRepository;

@Service
public class LogService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private  LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void deleteLog(int id) {
        logRepository.deleteById(id);
    }

    public void updateLog(Log log) {
        logRepository.save(log);
    }

    public Log addLog(Log log) {
        return logRepository.save(log);
    }

    public Log findLog(int id) {
        return logRepository.findById(id).orElse(null);
    }

    public List<Log> findLogs() {
        return logRepository.findAll();
    }

    public Log assignUserToLog(int log_id, int user_id) {
        Log log = logRepository.findById(log_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        log.assignUser(user);
        return logRepository.save(log);
    }

    public User findUserOfLog(int log_id) {
        Log log = logRepository.findById(log_id).orElse(null);
        User user = log.getUser();
        return user;
    }
    
}
