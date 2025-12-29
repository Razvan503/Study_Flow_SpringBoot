package org.example.study.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Analytics {
    private ArrayList<RecentActivity> recentactivities;

    private String studyTimeThisWeek;
    private String studyTimeChange;

    private Integer sessionsCompleted;

    private String sessionsChange;

    private Integer avgFocusScore;
    private String focusChange;
    private String bestFocusDay;

    private Integer streakDays;
    private String streakTrend;
    private Integer longestStreakDays;

    public ArrayList<RecentActivity> getRecentactivities() {
        return recentactivities;
    }

    public void addActivity(RecentActivity activity) {
       recentactivities.add(activity);
    }

    public String getStudyTimeThisWeek() {
        return studyTimeThisWeek;
    }

    public void setStudyTimeThisWeek(String studyTimeThisWeek) {
        this.studyTimeThisWeek = studyTimeThisWeek;
    }

    public String getStudyTimeChange() {
        return studyTimeChange;
    }

    public void setStudyTimeChange(String studyTimeChange) {
        this.studyTimeChange = studyTimeChange;
    }

    public Integer getSessionsCompleted() {
        return sessionsCompleted;
    }

    public void setSessionsCompleted(Integer sessionsCompleted) {
        this.sessionsCompleted = sessionsCompleted;
    }

    public String getSessionsChange() {
        return sessionsChange;
    }

    public void setSessionsChange(String sessionsChange) {
        this.sessionsChange = sessionsChange;
    }

    public Integer getAvgFocusScore() {
        return avgFocusScore;
    }

    public void setAvgFocusScore(Integer avgFocusScore) {
        this.avgFocusScore = avgFocusScore;
    }

    public String getFocusChange() {
        return focusChange;
    }

    public void setFocusChange(String focusChange) {
        this.focusChange = focusChange;
    }

    public String getBestFocusDay() {
        return bestFocusDay;
    }

    public void setBestFocusDay(String bestFocusDay) {
        this.bestFocusDay = bestFocusDay;
    }

    public Integer getStreakDays() {
        return streakDays;
    }

    public void setStreakDays(Integer streakDays) {
        this.streakDays = streakDays;
    }

    public String getStreakTrend() {
        return streakTrend;
    }

    public void setStreakTrend(String streakTrend) {
        this.streakTrend = streakTrend;
    }

    public Integer getLongestStreakDays() {
        return longestStreakDays;
    }

    public void setLongestStreakDays(Integer longestStreakDays) {
        this.longestStreakDays = longestStreakDays;
    }
}
