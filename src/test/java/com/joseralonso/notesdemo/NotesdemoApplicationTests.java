package com.joseralonso.notesdemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joseralonso.notesdemo.restcontroller.NotesRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NotesdemoApplicationTests {

	@Autowired
	NotesRestController notesRestController;
	
	@Test
	void contextLoads() {
	    Assertions.assertThat(notesRestController).isNot(null);
	}

}
