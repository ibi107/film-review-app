package com.ibtesamahmad.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Review entity stored in the "reviews" collection in MongoDB.
 */
@Document(collection = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    private ObjectId id;

    private String body;

    /**
     * Constructor for creating a new review with a body.
     * 
     * @param body Text content of the review.
     */
    public Review(String body) {
        this.body = body;
    }
}
