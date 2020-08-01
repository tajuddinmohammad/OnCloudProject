package com.onCloud.memberService.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String movieName;
	private String member;
	private Boolean isFavorite;

	public Movie() {
	}

	public Movie(String id, String movieName, String member, Boolean isFavorite) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.member = member;
		this.isFavorite = isFavorite;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
}