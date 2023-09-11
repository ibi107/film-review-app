package com.ibtesamahmad.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring Data MongoDB repository for performing CRUD operations on Review
 * entities.
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
