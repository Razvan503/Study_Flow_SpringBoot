package org.example.study.Models;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Analytics {
    private Integer studyTime;
    private Integer AvgFocusScore;
    private Integer sessionsCompleted;
    private ArrayList<String> recentActivities;

    public Analytics(Integer studyTime, Integer AvgFocusScore, Integer sessionsCompleted, ArrayList<String> recentActivities){
        this.studyTime = studyTime;
        this.AvgFocusScore = AvgFocusScore;
        this.sessionsCompleted = sessionsCompleted;
        this.recentActivities = recentActivities;
    }
    public Integer  getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Integer studyTime) {
        this.studyTime = studyTime;
    }

    public Integer getAvgFocusScore() {
        return AvgFocusScore;
    }

    public void setAvgFocusScore(Integer AvgFocusScore) {
        this.AvgFocusScore = AvgFocusScore;
    }

    public Integer getSessionsCompleted() {
        return sessionsCompleted;
    }

    public void setSessionsCompleted(Integer sessionsCompleted) {
        this.sessionsCompleted = sessionsCompleted;
    }

    public ArrayList<String> getRecentActivities() {
        return recentActivities;
    }

    public void setRecentActivities(ArrayList<String> recentActivities) {
        this.recentActivities = recentActivities;
    }
}
