package org.example.study.Models.DTO;

public class ChapterRequest {
    private String chapter_name;
    private Integer time;
   
    public ChapterRequest(String chapter_name,Integer time){
        this.chapter_name= chapter_name;
        this.time= time;
    }

    public String getName() {
        return chapter_name;
    }

    public void setName(String name) {
        this.chapter_name= name;
    }

    public Integer getDuration() {
        return time;
    }

    public void setDuration(Integer duration) {
        this.time = duration;
    }
}
