package com.ibtesamahmad.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the backend application.
 */
@SpringBootApplication
public class MoviesApplication {

	/**
	 * The entry point of the application.
	 * 
	 * @param args Command-line arguments (if needed).
	 */
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
}
