package org.example.study.Models;

import org.example.study.Models.JpaModels.Chapter;
import org.example.study.Models.JpaModels.Subject;

import java.util.ArrayList;

public class SubjectResponse {

    private String name;
    private String description;
    private Integer progress;
    private ArrayList<Chapter> chapters;

    public SubjectResponse(String name, String description, Integer progress, ArrayList<Chapter> chapters){
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.chapters = chapters;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}
