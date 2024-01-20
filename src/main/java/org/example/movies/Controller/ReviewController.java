package org.example.movies.Controller;

import org.example.movies.Model.Review;
import org.example.movies.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        String reviewBody = payload.get("reviewBody");
        String imdbId = payload.get("imdbId");

        // Check if the payload contains details for a full review
        if (payload.containsKey("title") && payload.containsKey("reviewer")
        && payload.containsKey("rating") && payload.containsKey("comment")) {

            String title = payload.get("title");
            String reviewer = payload.get("reviewer");
            Double rating = Double.parseDouble(payload.get("rating"));

            return new ResponseEntity<>(reviewService.createReviewWithDetails(title, reviewer, rating, reviewBody, imdbId), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(reviewService.createReview(reviewBody, imdbId), HttpStatus.CREATED);
        }
    }
}
