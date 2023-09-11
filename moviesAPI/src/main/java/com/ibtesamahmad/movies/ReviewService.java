package com.ibtesamahmad.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * A service class for handling Review-related operations.
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new review and associate it with a movie.
     * 
     * @param reviewBody Text content of the review.
     * @param imdbId     The IMDb id of the movie to associate the review with.
     * @return The created Review entity.
     */
    public Review createReview(String reviewBody, String imdbId) {
        // Create a new review and insert it into the reviewRepository
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Update the associated movie's reviewIds field to include the new review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
