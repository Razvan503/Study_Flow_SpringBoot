package org.example.study.Repository;

import org.example.study.Models.JpaModels.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter,Long> {
    List<Chapter> findBySubject_Name_AndSubject_User_Username(String subjectName,String username);
}
