package com.joseralonso.notesdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseralonso.notesdemo.entity.Note;

public interface NotesRepository extends JpaRepository<Note, Integer> {

}
