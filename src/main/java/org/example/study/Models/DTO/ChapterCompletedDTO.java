package org.example.study.Models.DTO;

public class ChapterCompletedDTO {
	private String chapter_name;
	private Boolean isCompleted;
	private String subject;

	public ChapterCompletedDTO(String chapter_name, Boolean isCompleted, String subject) {
		this.chapter_name = chapter_name;
		this.isCompleted = isCompleted;
		this.subject = subject;
	}

	public ChapterCompletedDTO() {
	}

	public String getChapter_name() {
		return this.chapter_name;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setChapter_name(String name) {
		chapter_name = name;
	}

	public void setIsCompleted(Boolean completed) {
		isCompleted = completed;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
