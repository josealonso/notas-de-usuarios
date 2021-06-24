package com.joseralonso.notesdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.joseralonso.notesdemo.entity.Note;

@CrossOrigin("http://localhost:4200")
public interface NotesJpaRepository extends CrudRepository<Note, Integer> {

}
