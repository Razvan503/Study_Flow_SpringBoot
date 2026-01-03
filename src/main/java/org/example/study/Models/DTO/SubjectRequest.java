package org.example.study.Models.DTO;

import java.util.List;

public class SubjectRequest {
    private String name;
    private String description;
    private Integer progress;
    private List<ChapterRequest> chapters;

    public SubjectRequest(String name, String description, Integer progress, List<ChapterRequest> chapters) {
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

    public List<ChapterRequest> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterRequest> chapters) {
        this.chapters = chapters;
    }
}
