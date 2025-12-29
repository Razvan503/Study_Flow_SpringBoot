package org.example.study.Models;

public class RecentActivity {
    private String text;
    private Integer duration;
    private String timeAgo;

    public String getText(){
        return text;
    }

    public Integer getDuration(){
        return duration;
    }

    public String getTimeAgo(){
        return timeAgo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }
}
