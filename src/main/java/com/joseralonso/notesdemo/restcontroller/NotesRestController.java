package com.joseralonso.notesdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseralonso.notesdemo.entity.Note;
import com.joseralonso.notesdemo.service.NotesService;

@RestController
@RequestMapping("/api/v1/notesApp")
public class NotesRestController {

	private NotesService notesService;
	
	@Autowired
	public NotesRestController(NotesService theNotesService) {
	    notesService = theNotesService;
	}

	@GetMapping("/notes")
	public List<Note> findAll() {
		return notesService.findAll();
	}

	@PostMapping("/notes")
	public Note addNote(@RequestBody String usuario) {
		int lastNoteId = 0;   // TODO
		Note note = new Note();
		note.setId(lastNoteId++);
		return note;
	}

	@PutMapping("/notes")
	public Note updateNote(@RequestBody Note note) {
		notesService.save(note);
		return note;
	}
	
	@DeleteMapping("/notes/{noteId}")
	public String deleteNote(@PathVariable int noteId) {
		Note tempNote = notesService.findById(noteId);
		if (tempNote == null) {
			throw new RuntimeException("Note id not found - " + noteId);
		}
		notesService.deleteById(noteId);
		return "Deleted note id - " + noteId;
	}

}
