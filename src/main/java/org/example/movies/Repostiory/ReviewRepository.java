package org.example.movies.Repostiory;

import org.bson.types.ObjectId;
import org.example.movies.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
