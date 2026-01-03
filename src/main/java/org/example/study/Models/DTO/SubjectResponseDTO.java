package org.example.study.Models.DTO;

import java.util.List;

public class SubjectResponseDTO {
    private String name;
    private String description;
    private Integer progress;
    private List<ChapterDTO> chapters;

    public SubjectResponseDTO(String name, String description, Integer progress, List<ChapterDTO> chapters) {
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.chapters = chapters;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getProgress() { return progress; }
    public void setProgress(Integer progress) { this.progress = progress; }
    public List<ChapterDTO> getChapters() { return chapters; }
    public void setChapters(List<ChapterDTO> chapters) { this.chapters = chapters; }
}
