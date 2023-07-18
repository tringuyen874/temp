package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Log;
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
    
    @PostMapping("/logs/{id}")
    public Log addLogWithId(@PathVariable int id, @RequestBody Log log) {
        return logService.addLogWithId(id, log);
    }

    // @PutMapping("/logs/{id}")
    // public void updateLog(@PathVariable("id") int id, @RequestBody Log log) {
    //     log.setLogId(id);
    //     logService.updateLog(log);
    // }

    // @DeleteMapping("/logs/{id}")
    // public void deleteLog(@PathVariable int id) {
    //     logService.deleteLog(id);
    // }
}
