package com.vitoria.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vitoria.workshopmongo.dto.AuthorDTO;

@Document
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;	
	@DBRef(lazy=true)
	List<Comment> comments = new ArrayList();
	
	public Post() {
		super();
	}

	

	public Post(String id, Date date, String title, String body, AuthorDTO author, List<Comment> comments) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
		this.comments = comments;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
