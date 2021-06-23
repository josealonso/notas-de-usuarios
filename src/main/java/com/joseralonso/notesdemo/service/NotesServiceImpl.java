package com.joseralonso.notesdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseralonso.notesdemo.dao.NotesRepository;
import com.joseralonso.notesdemo.entity.Note;

public class NotesServiceImpl implements NotesService {

	private NotesRepository notesRepository;

	@Autowired
	public NotesServiceImpl(NotesRepository notesRepository) {
		this.notesRepository = notesRepository;
	}
	
	@Override
	public List<Note> findAll() {
		return notesRepository.findAll();
	}

	@Override
	public List<Note> findByUser(String user) {
		List<Note> allNotes = notesRepository.findAll();
		List<Note> notesByUser = allNotes.stream().filter(elem -> elem.getUserName().equals(user))
		                                          .collect(Collectors.toList());
		if (notesByUser.isEmpty()) {
			throw new RuntimeException("Did not find user - " + user);
		}
		
		return notesByUser;
	}

	@Override
	public Note findById(int index) {
		Optional<Note> result = notesRepository.findById(index);
		Note theNote = null;
		if (result.isPresent()) {
			theNote = result.get();
		}
		else {
			throw new RuntimeException("Did not find note id - " + index);
		}
		return theNote;
	}

	@Override
	public void save(Note note) {
		notesRepository.save(note);
	}

	@Override
	public void deleteById(int index) {
		notesRepository.deleteById(index);
	}

}
