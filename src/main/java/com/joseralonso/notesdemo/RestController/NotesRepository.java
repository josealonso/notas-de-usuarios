package com.joseralonso.notesdemo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joseralonso.notesdemo.Entity.Note;
import com.joseralonso.notesdemo.Service.NotesService;

//@SpringBootApplication
@RestController
@RequestMapping("/api/v1/notes")
public class NotesRepository {

	private NotesService notesService;
	
	@Autowired
	public NotesRestController(NotesService theNotesService) {
	    notesService = theNotesService;
	}

	@GetMapping("/usuario/list")
	public List<Note> findAll() {
		return notesService.findAll();
	}

	@RequestMapping(value = "/usuario/new", method = RequestMethod.POST)
	@ResponseBody()
	String HelloWorld22() {
		return "Hola a todo el mudo";
	}

	@RequestMapping(value = "/usuario/{noteNumber}/delete", method = RequestMethod.DELETE)
	@ResponseBody()
	String HelloWorld3() {
		return "Hola a todo el mudo";
	}

	@RequestMapping(value = "/usuario/{noteNumber}/edit", method = RequestMethod.PUT)
	@ResponseBody()
	String HelloWorld4() {
		return "Hola a todo el mudo";
	}

//	public static void main(String[] args) {
//		SpringApplication.run(NotesdemoApplication.class, args);
//	}

}
