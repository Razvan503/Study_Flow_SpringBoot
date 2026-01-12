package org.example.study.Models.DTO;

public class UpcomingSessionsDTO {
    private String name;

    public UpcomingSessionsDTO() {
    }

    public UpcomingSessionsDTO(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }

}
