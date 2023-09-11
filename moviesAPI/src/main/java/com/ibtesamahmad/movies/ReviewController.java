package com.ibtesamahmad.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class for handling Review-related HTTP requests.
 */
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * Create a new review.
     * 
     * @param payload A JSON object containing reviewBody and imdbId fields.
     * @return A ResponseEntity containing the created Review entity and a HTTP
     *         status code.
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
