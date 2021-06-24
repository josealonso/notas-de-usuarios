package com.joseralonso.notesdemo.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
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

@ExtendWith(SpringExtension.class)
@WebMvcTest(NotesRestController.class)
public class NotesRestControllerTests {

	@MockBean
	NotesService notesService;

	@Autowired
	MockMvc mockMvc;

//	@Test
//	public void testfindAll() throws Exception {
//		Note note_1 = new Note(1, "Jose", "titulo_1", "Esta es la nota-1");
//		Note note_2 = new Note(2, "Jesus", "título", "Esta es la nota-2");
//		List<Note> notesList = new ArrayList<>();
//		notesList.add(note_1);
//		notesList.add(note_2);
//
//		Mockito.when(notesService.findAll()).thenReturn(notesList);
//		mockMvc.perform(get("/notes")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
//				.andExpect(jsonPath("$[0].userName", Matchers.is("Jose")))
//				.andExpect(jsonPath("$[0].noteTitle", Matchers.is("titulo_1")))
//				.andExpect(jsonPath("$[0].noteText", Matchers.is("Esta es la nota-1")));
//	}

//	@Test
//	public void testAddNote() {
//		Mockito.when(notesService.save(new Note()))
//		.thenReturn(status().isOk());    // TODO
//		mockMvc.perform(post("/notes")).andExpect(status().isOk()); // TODO
//	}
//
//	@PutMapping("/notes")
//	public ResponseEntity<Note> updateNote(@RequestBody Note note) {
//		notesService.save(note);
//		return new ResponseEntity<>(note, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/notes/{noteId}")
//	public ResponseEntity<String> deleteNote(@PathVariable int noteId) {
//		Note tempNote = notesService.findById(noteId);
//		if (tempNote == null) {
//			return new ResponseEntity<>("Note id not found - " + noteId, HttpStatus.NOT_FOUND);
//		} else {
//			notesService.deleteById(noteId);
//			return new ResponseEntity<>("Deleted note id - " + noteId, HttpStatus.OK);
//		}
//	}

}
