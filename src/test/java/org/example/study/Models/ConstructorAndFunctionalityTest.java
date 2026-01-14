package org.example.study.Models;

import org.example.study.Models.DTO.AccountDTO;
import org.example.study.Models.JpaModels.Chapter;
import org.example.study.Models.JpaModels.Subject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorAndFunctionalityTest {

    @Test
    public void accountDTO_Constructor_ShouldSetFieldsCorrectly() {
        String expectedUsername = "testUser";
        String expectedEmail = "test@example.com";
        String expectedFullname = "Test User";

        AccountDTO accountDTO = new AccountDTO(expectedUsername, expectedEmail, expectedFullname);

        assertEquals(expectedUsername, accountDTO.getUsername());
        assertEquals(expectedEmail, accountDTO.getEmail());
        assertEquals(expectedFullname, accountDTO.getFullname());
    }

    @Test
    public void chapter_DefaultConstructor_ShouldCreateInstance() {
        Chapter chapter = new Chapter();
        assertNotNull(chapter);
        assertNull(chapter.getTitle());
    }

    @Test
    public void subject_DefaultConstructor_ShouldCreateInstance() {
        Subject subject = new Subject();
        assertNotNull(subject);
        assertNull(subject.getName());
    }

    @Test
    public void chapter_SettersAndGetters_ShouldWorkCorrectly() {
        Chapter chapter = new Chapter();
        String title = "Intro to Logic";
        String description = "Basic principles";
        Integer time = 45;
        Boolean isComplete = true;

        chapter.setTitle(title);
        chapter.setDescription(description);
        chapter.setTime(time);
        chapter.setIsComplete(isComplete);

        assertEquals(title, chapter.getTitle());
        assertEquals(description, chapter.getDescription());
        assertEquals(time, chapter.getTime());
        assertTrue(chapter.getIsComplete());
    }

    @Test
    public void subject_SetChapters_ShouldStoreList() {
        Subject subject = new Subject();
        Chapter c1 = new Chapter();
        c1.setTitle("C1");
        Chapter c2 = new Chapter();
        c2.setTitle("C2");

        List<Chapter> chapters = new ArrayList<>();
        chapters.add(c1);
        chapters.add(c2);

        subject.setChapters(chapters);

        assertNotNull(subject.getChapters());
        assertEquals(2, subject.getChapters().size());
        assertEquals("C1", subject.getChapters().get(0).getTitle());
    }

    @Test
    public void accountDTO_Setters_ShouldUpdateValues() {
        AccountDTO account = new AccountDTO("oldUser", "old@mail.com", "Old Name");

        account.setUsername("newUser");
        account.setEmail("new@mail.com");
        account.setFullname("New Name");

        assertEquals("newUser", account.getUsername());
        assertEquals("new@mail.com", account.getEmail());
        assertEquals("New Name", account.getFullname());
    }
}
