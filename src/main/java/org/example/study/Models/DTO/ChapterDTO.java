package org.example.study.Models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChapterDTO {
	@JsonProperty("chapter_name")
	private String name;

	@JsonProperty("time")
	private Integer duration;

	private Boolean isCompleted;

	public ChapterDTO(String name, Integer duration, Boolean isCompleted) {
		this.name = name;
		this.duration = duration;
		this.isCompleted = isCompleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
