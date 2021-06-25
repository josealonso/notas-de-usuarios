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
	private String user;

	@Column(name = "note")
	private String note;

	public Note() {
	}

	public Note(int id, String userName, String noteText) {
		this.id = id;
		this.user = userName;
		this.note = noteText;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", user=" + user + ", note=" + note + "]";
	}
	
}
