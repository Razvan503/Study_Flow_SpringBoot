package org.example.study.Models.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChapterDTO {
    // We use @JsonProperty to make the JSON key "chapter_name"
    // while keeping the Java variable clean.
    @JsonProperty("chapter_name")
    private String name;

    @JsonProperty("time")
    private Integer duration;

    // Constructor
    public ChapterDTO(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}
