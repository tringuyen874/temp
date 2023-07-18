package com.example.english.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.Result;
import com.example.english.respository.ResultRepository;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void addResult(Result result) {
        resultRepository.save(result);   
    }

    public Result findResult(int id) {
        return resultRepository.findById(id).orElse(null);
    }

    public void updateResult(Result result) {
        resultRepository.save(result);
    }

    public void deleteResult(int id) {
        resultRepository.deleteById(id);
    }

    public List<Result> findResults() {
        return resultRepository.findAll();
    }

    public String findUserFromResult(Integer id) {
        
        return resultRepository.findUserFromResult(id);
    }
}
