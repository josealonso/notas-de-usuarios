package com.joseralonso.notesdemo.service;
 
import java.util.List;

import com.joseralonso.notesdemo.entity.Note;

public interface NotesService {

	public List<Note> findAll();
	
	public List<Note> findByUser(String user);
	
	public Note findById(int index);
	
	public void save(Note note);
	
	public void deleteById(int index);
}
