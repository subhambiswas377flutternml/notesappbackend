package com.notes.app.noteapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class NoteappApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteappApplication.class, args);
	}

}
