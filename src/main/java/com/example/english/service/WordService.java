package com.example.english.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.english.model.Word;
import com.example.english.respository.WordRepository;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> findWords() {
        return wordRepository.findAll();
    }

    public void addWord(Word word) {
        wordRepository.save(word);
    }

}
