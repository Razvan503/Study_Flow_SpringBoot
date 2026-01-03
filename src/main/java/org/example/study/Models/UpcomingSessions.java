package org.example.study.Models;

public class UpcomingSessions {
    private String name;
    private String chapter;

    public UpcomingSessions(String name,String chapter){
        this.name = name;
        this.chapter = chapter;
    }

    public String getName(){
        return name;
    }

    public String getChapter(){
        return chapter;
    }
}
