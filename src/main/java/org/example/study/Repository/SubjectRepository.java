package org.example.study.Repository;

import org.example.study.Models.JpaModels.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findByUser_Username(String userUsername);
}
