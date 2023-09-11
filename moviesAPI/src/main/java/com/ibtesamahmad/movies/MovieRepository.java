package com.ibtesamahmad.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring Data MongoDB repository for performing CRUD operations on Movie
 * entities.
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    /**
     * Find a movie by its IMDb id.
     * 
     * @param imdbId The IMDb id of the movie to search for.
     * @return An Optional containing the movie if found, or empty if not.
     */
    Optional<Movie> findMovieByImdbId(String imdbId);
}
