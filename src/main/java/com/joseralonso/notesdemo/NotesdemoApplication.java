package com.joseralonso.notesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@RequestMapping("/api/v1/notes")
public class NotesdemoApplication {

	@RequestMapping(value = "/usuario/list", method = RequestMethod.GET)
	@ResponseBody()
	String HelloWorld() {
		return "Hola a todo el mudo";
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

	public static void main(String[] args) {
		SpringApplication.run(NotesdemoApplication.class, args);
	}

}
