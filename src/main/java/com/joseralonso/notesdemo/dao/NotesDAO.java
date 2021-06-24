package com.joseralonso.notesdemo.dao;

import java.util.List;

import com.joseralonso.notesdemo.entity.Note;

public interface NotesDAO {

	public List<Note> findAll();

	public Note findById(int index);

	public void save(Note note);

	public void deleteById(int index);
}
