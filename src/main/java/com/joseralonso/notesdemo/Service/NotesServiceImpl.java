package com.joseralonso.notesdemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseralonso.notesdemo.Entity.Note;
import com.joseralonso.notesdemo.RestController.NotesRepository;

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
