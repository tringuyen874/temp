package com.example.english.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.english.model.Word;
import com.example.english.service.WordService;

@RestController
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public List<Word> findWords() {
        return wordService.findWords();
    }

    @PostMapping("/words")
    public void addWord(@RequestBody Word word) {
        wordService.addWord(word);
    }
}
