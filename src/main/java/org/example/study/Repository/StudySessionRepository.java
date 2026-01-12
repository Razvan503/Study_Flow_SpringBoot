package org.example.study.Repository;

import org.example.study.Models.JpaModels.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<Session,Long> {

    List<Session> findByEmail(String email);
}
