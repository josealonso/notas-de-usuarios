package com.joseralonso.notesdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

import com.joseralonso.notesdemo.entity.Note;

public class NotesDAOHibernateImpl implements NotesDAO {

	private EntityManager entityManager;

	public NotesDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Note> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Query<Note> theQuery = currentSession.createQuery("from notes", Note.class); // using native Hibernate API
		List<Note> notes = theQuery.getResultList();
		return notes;
	}

	@Override
	public Note findById(int index) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, index);
		return note;
	}

	@Override
	public void save(Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(note);
	}

	@Override
	public void deleteById(int index) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from notes where id=:noteId");
		theQuery.setParameter("noteId", index);
        theQuery.executeUpdate();
	}

}
