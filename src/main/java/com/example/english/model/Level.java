package com.example.english.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
    @Id
    @Column(name = "lv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int levelId;

    @Column(name = "lv_name")
    String levelName;

    @Column(name = "lv_description")
    String levelDescription;

    public int getLevelId() {
        return levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    @Override
    public String toString() {
        return "Level [levelId=" + levelId + ", levelName=" + levelName + ", levelDescription=" + levelDescription
                + "]";
    }

    public Level(String levelName, String levelDescription) {
        this.levelName = levelName;
        this.levelDescription = levelDescription;
    }

    
}
