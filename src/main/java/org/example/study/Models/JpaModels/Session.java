package org.example.study.Models.JpaModels;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_date",nullable = false)
    private LocalDateTime sessionTime;

    @Column(name = "subject_name",nullable = false)
    private String subject_name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "is_completed")
    private Boolean is_completed;

    @Column(name = "duration",nullable = false)
    private Integer duration;

    public Session(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Boolean is_completed) {
        this.is_completed = is_completed;
    }

    public void setDuration(Integer duration){
        this.duration = duration;
    }

    public Integer getDuration(){
        return this.duration;
    }
}