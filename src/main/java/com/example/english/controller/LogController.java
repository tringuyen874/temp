package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Log;
import com.example.english.model.User;
import com.example.english.service.LogService;

@RestController
public class LogController {
    
    @Autowired
    private LogService logService;

    @GetMapping("/logs")
    public List<Log> findLogs() {
        return logService.findLogs();
    }

    // @GetMapping("/logs/{id}")
    // public Log findLog(@PathVariable int id) {
    //     return logService.findLog(id);
    // }
    
    // @PostMapping("/logs/{id}")
    // public Log addLogWithId(@PathVariable int id, @RequestBody Log log) {
    //     return logService.addLogWithId(id, log);
    // }

    @PutMapping("/logs/{log_id}/users/{user_id}")
    public Log assignUserToLog(@PathVariable("log_id") int log_id, @PathVariable("user_id") int user_id) {
        return logService.assignUserToLog(log_id, user_id);
    }

    // @DeleteMapping("/logs/{id}")
    // public void deleteLog(@PathVariable int id) {
    //     logService.deleteLog(id);
    // }

    @GetMapping("/logs/{id}/users")
    public User findUserOfLog(@PathVariable int id) {
        return logService.findUserOfLog(id);
    }

}
