package org.example.study.Models.DTO;

public class ChapterRequest {
	private String chapter_name;
	private Integer time;
	private String subject;

	public ChapterRequest(String chapter_name, Integer time, String subject) {
		this.chapter_name = chapter_name;
		this.time = time;
		this.subject = subject;
	}

	public String getName() {
		return chapter_name;
	}

	public void setName(String name) {
		this.chapter_name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getDuration() {
		return time;
	}

	public void setDuration(Integer duration) {
		this.time = duration;
	}
}
