package com.lambert.errorhandling.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private @NonNull String name;
	private @NonNull String author;
	private @DateTimeFormat(pattern = "dd/MM/yyyy") Date releaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
