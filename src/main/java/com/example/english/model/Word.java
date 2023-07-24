package com.example.english.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "word")
public class Word {
    @Id
    @Column(name = "wd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int wordId;

    @Column(name = "wd_name")
    String wordName;

    @Column(name = "wd_meaning")
    String wordMeaning;

    @Column(name = "wd_image_url")
    String wordImageUrl;

    @Column(name = "wd_audio_url")
    String wordAudioUrl;

    @Column(name = "wd_attribute")
    String wordAttribute;

    @Column(name = "wd_example")
    String wordExample;
    
    @Column(name = "topic_id")
    int topicId;

    public int getWordId() {
        return wordId;
    }

    public String getWordName() {
        return wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public String getWordImageUrl() {
        return wordImageUrl;
    }

    public String getWordAudioUrl() {
        return wordAudioUrl;
    }

    public String getWordAttribute() {
        return wordAttribute;
    }

    public String getWordExample() {
        return wordExample;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }

    public void setWordImageUrl(String wordImageUrl) {
        this.wordImageUrl = wordImageUrl;
    }

    public void setWordAudioUrl(String wordAudioUrl) {
        this.wordAudioUrl = wordAudioUrl;
    }

    public void setWordAttribute(String wordAttribute) {
        this.wordAttribute = wordAttribute;
    }

    public void setWordExample(String wordExample) {
        this.wordExample = wordExample;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Word [wordId=" + wordId + ", wordName=" + wordName + ", wordMeaning=" + wordMeaning + ", wordImageUrl="
                + wordImageUrl + ", wordAudioUrl=" + wordAudioUrl + ", wordAttribute=" + wordAttribute
                + ", wordExample=" + wordExample + ", topicId=" + topicId + "]";
    }

    public Word() {
    }

    public Word(String wordName, String wordMeaning, String wordImageUrl, String wordAudioUrl, String wordAttribute,
            String wordExample, int topicId) {
        this.wordName = wordName;
        this.wordMeaning = wordMeaning;
        this.wordImageUrl = wordImageUrl;
        this.wordAudioUrl = wordAudioUrl;
        this.wordAttribute = wordAttribute;
        this.wordExample = wordExample;
        this.topicId = topicId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "word")
    private Set<Result> results;
}
