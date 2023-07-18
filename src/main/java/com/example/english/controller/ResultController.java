package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Result;
import com.example.english.service.ResultService;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/results")
    public List<Result> findResults() {
        return resultService.findResults();
    }

    // @GetMapping("/results/{id}")
    @GetMapping("/results/{rs_id}")
    public String findUserFromResult(@PathVariable("rs_id") Integer id) {
        return resultService.findUserFromResult(id);
    }

}
