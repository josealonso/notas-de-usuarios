package com.joseralonso.notesdemo.Service;

import java.util.List;

import com.joseralonso.notesdemo.Entity.Note;

public interface NotesService {

	public List<Note> findAll();
	
	public Note findById(int index);
	
	public void save(Note note);
	
	public void deleteById(int index);
}
