package com.example.english.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.Result;
import com.example.english.model.Word;
import com.example.english.respository.ResultRepository;
import com.example.english.respository.WordRepository;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private WordRepository wordRepository;

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

    public Result assignWordToResult(int rs_id, int word_id) {
        Result result = resultRepository.findById(rs_id).orElse(null);
        Word word = wordRepository.findById(word_id).orElse(null);
        result.assignWord(word);
        return resultRepository.save(result);
    }

    public Word findWordFromResult(int rs_id) {
        Result result = resultRepository.findById(rs_id).orElse(null);
        Word word = result.getWord();
        return word;
    }
}
