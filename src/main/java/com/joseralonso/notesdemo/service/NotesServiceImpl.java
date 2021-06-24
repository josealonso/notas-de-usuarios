package com.joseralonso.notesdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseralonso.notesdemo.dao.NotesJpaRepository;
import com.joseralonso.notesdemo.entity.Note;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesJpaRepository notesJpaRepository;

	public List<Note> findAll() {
		return (List<Note>) notesJpaRepository.findAll();
	}

	@Override
	public List<Note> findByUser(String user) {
		List<Note> allNotes = (List<Note>) notesJpaRepository.findAll();
		List<Note> notesByUser = allNotes.stream().filter(elem -> elem.getUserName().equals(user))
		                                          .collect(Collectors.toList());
		if (notesByUser.isEmpty()) {
			throw new RuntimeException("Did not find user - " + user);
		}
		
		return notesByUser;
	}

	@Override
	public Note findById(int index) {
		Optional<Note> result = notesJpaRepository.findById(index);
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
		notesJpaRepository.save(note);
	}

	@Override
	public void deleteById(int index) {
		notesJpaRepository.deleteById(index);
	}

}
