package com.ibtesamahmad.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class for handling Movie-related HTTP requests.
 */
@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * Retrieve a list of all movies.
     * 
     * @return A ResponseEntity containing a list of Movie entities and a HTTP
     *         status code.
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    /**
     * Retrieve a single movie by its IMDb id.
     * 
     * @param imdbId The IMDb ID of the movie to retrieve.
     * @return A ResponseEntity containing an Optional of Movie and a HTTP status
     *         code.
     */
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
