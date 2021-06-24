package com.joseralonso.notesdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.joseralonso.notesdemo.dao.NotesJpaRepository;
import com.joseralonso.notesdemo.entity.Note;

@ExtendWith(MockitoExtension.class)
public class NotesServiceTests {

	@InjectMocks
	NotesService service;
	
	@Mock
	NotesJpaRepository dao;

	List<Note> notesList = new ArrayList<>();
	Note note_1;
	Note note_2;
	Note note_3;
	int notesListSize;
	int notesOfJose;
	
	@BeforeEach
	public void initData() {
		note_1 = new Note(1, "Jose", "titulo_1", "Esta es la nota-1");
		note_2 = new Note(2, "Jesus", "título", "Esta es la nota-2");
		note_3 = new Note(2, "Jose", "título", "Esta es la nota-3");
		notesOfJose = 2;
		notesList.add(note_1);
		notesList.add(note_2);
		notesList.add(note_3);
		notesListSize = notesList.size();
	}
	
	@Test
	public void testFindAllNotes() {
	
		when(dao.findAll()).thenReturn(notesList);
		
		// test
		List<Note> notes2List = service.findAll();
		assertEquals(notesListSize, notes2List.size());
		verify(dao, times(1)).findAll();
	}

	@Test
	public void testCreateOrSaveNote() {
		service.save(note_1);
		verify(dao, times(1)).save(note_1);
	}

	@Test
	public void testDeleteNote() {
		service.deleteById(0);
		verify(dao, times(1)).delete(note_1);
	}

	@Test
	public void testFindByUser() {
		List<Note> notesByUser = service.findByUser("Jose");
		assertEquals(notesOfJose, notesByUser.size());
		verify(dao, times(1));
	}

}
