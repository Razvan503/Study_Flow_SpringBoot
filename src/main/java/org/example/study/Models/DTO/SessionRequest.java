package org.example.study.Models.DTO;

import org.hibernate.sql.exec.spi.CacheableJdbcOperation;

public class SessionRequest {
    private String Subject;
    private String Chapter;
    private String Description;
    private String Date;
    private String Time;
    private Integer Duration;

    public SessionRequest(String Subject,String Chapter,String Description,String Date,String Time,Integer Duration){
        this.Subject = Subject;
        this.Chapter = Chapter;
        this.Description = Description;
        this.Date = Date;
        this.Time = Time;
        this.Duration = Duration;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String Chapter) {
        this.Chapter = Chapter;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer Duration) {
        this.Duration = Duration;
    }

}
