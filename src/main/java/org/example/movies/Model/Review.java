package org.example.movies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "reviews")
@Data
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String title;
    private String reviewer;
    private Double rating;
    private String reviewBody;

    public Review(String title, String reviewer, Double rating, String reviewBody) {
        this.title = title;
        this.reviewer = reviewer;
        this.rating = rating;
        this.reviewBody = reviewBody;
    }
    public Review(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
