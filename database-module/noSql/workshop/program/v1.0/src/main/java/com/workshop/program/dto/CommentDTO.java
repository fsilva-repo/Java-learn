package com.workshop.program.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private LocalDateTime date;
  private String text;
  private AuthorDTO author;
  public CommentDTO() {}
  public CommentDTO(LocalDateTime date, String text, AuthorDTO author) {
    this.date = date;
    this.text = text;
    this.author = author;
  }
  public LocalDateTime getDate() {
    return date;
  }
  public void setDate(LocalDateTime date) {
    this.date = date;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public AuthorDTO getAuthor() {
    return author;
  }
  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }

  

}
