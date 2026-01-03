package org.example.study.Controllers;

import org.example.study.Models.DTO.ChapterDTO;
import org.example.study.Models.DTO.SubjectResponseDTO;
import org.example.study.Models.JpaModels.Chapter;
import org.example.study.Models.JpaModels.Subject;
import org.example.study.Models.SubjectResponse;
import org.example.study.Repository.ChapterRepository;
import org.example.study.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursesController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<SubjectResponseDTO>> getSubjects(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<Subject> subjectEntities = subjectRepository.findByUser_Username(username);

        List<SubjectResponseDTO> responseList = new ArrayList<>();

        for(Subject s: subjectEntities){
            List<ChapterDTO> chapters = new ArrayList<>();
            for(Chapter c : s.getChapters()){
                chapters.add(new ChapterDTO(c.getTitle(),c.getTime()));
            }

            SubjectResponseDTO subject = new SubjectResponseDTO(s.getName(),s.getDescription(),s.getProgress(),chapters);
            responseList.add(subject);
        }

        return ResponseEntity.ok(responseList);
    }

}