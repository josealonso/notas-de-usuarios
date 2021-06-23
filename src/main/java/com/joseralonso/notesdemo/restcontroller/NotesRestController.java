package com.joseralonso.notesdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	private NotesService notesService;
	
//	@Autowired
//	public NotesRestController(NotesService theNotesService) {
//	    notesService = theNotesService;
//	}

	@GetMapping("/notes")
	public ResponseEntity<List<Note>> findAll() {
		return new ResponseEntity<>(notesService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/notes")
	public ResponseEntity<Note> addNote(@RequestBody String usuario) {
		int lastNoteId = 0;   // TODO
		Note note = new Note();
		note.setId(lastNoteId++);
		return new ResponseEntity<>(note, HttpStatus.OK);
	}

	@PutMapping("/notes")
	public ResponseEntity<Note> updateNote(@RequestBody Note note) {
		notesService.save(note);
		return new ResponseEntity<>(note, HttpStatus.OK);
	}
	
	@DeleteMapping("/notes/{noteId}")
	public ResponseEntity<String> deleteNote(@PathVariable int noteId) {
		Note tempNote = notesService.findById(noteId);
		if (tempNote == null) {
			return new ResponseEntity<>("Note id not found - " + noteId, HttpStatus.NOT_FOUND);
		}
		else {
			notesService.deleteById(noteId);
			return new ResponseEntity<>("Deleted note id - " + noteId, HttpStatus.OK);
		}
	}

}
