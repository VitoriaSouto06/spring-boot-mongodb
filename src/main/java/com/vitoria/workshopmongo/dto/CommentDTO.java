package com.vitoria.workshopmongo.dto;

import java.util.Date;

import com.vitoria.workshopmongo.domain.Comment;

public class CommentDTO {
	private String text;
	private Date date;
	
	public CommentDTO() {
		
	}

	public CommentDTO(Comment comment) {
		
		this.text = comment.getText();
		this.date = comment.getDate();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
