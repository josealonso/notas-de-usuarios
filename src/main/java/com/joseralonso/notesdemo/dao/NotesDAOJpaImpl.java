package com.joseralonso.notesdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.joseralonso.notesdemo.Entity.Note;

@Repository
public class NotesDAOJpaImpl implements NotesDAO {

	private EntityManager entityManager;
	
	
	public NotesDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Note> findAll() {
		Query theQuery = entityManager.createQuery("from notes");  // using standard JPA API
		List<Note> notes = theQuery.getResultList();  
		return notes;		
	}

	@Override
	public Note findById(int index) {
		Note note = entityManager.find(Note.class, index);
		return note;
	}

	@Override
	public void save(Note note) {
		// save or update the note
		Note note2 = entityManager.merge(note);
		note.setId(note2.getId());
	}

	@Override
	public void deleteById(int index) {
		Query theQuery = entityManager.createQuery("delete from notes where id=:noteId");
		theQuery.setParameter("noteId", index);
        theQuery.executeUpdate();
	}

}
