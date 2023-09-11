package com.ibtesamahmad.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A service class for handling Movie-related operations.
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    /**
     * Retrieve a list of all movies.
     * 
     * @return A list of Movie entities.
     */
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    /**
     * Retrieve a single movie by its IMDb id.
     * 
     * @param imdbId The IMDb id of the movie to retrieve.
     * @return An Optional containing the movie if found, or empty if not.
     */
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
