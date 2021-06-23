package com.joseralonso.notesdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "user_name")
    private String userName;
	
	@Column(name = "note_title")
    private String noteTitle;
	
	@Column(name = "note_text")
    private String noteText;

	public Note() {
	}
	
	public Note(Integer id, String userName, String noteTitle, String noteText) {
		this.userName = userName;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", userName=" + userName + ", noteTitle=" + noteTitle + ", noteText=" + noteText
				+ "]";
	}
			
}

