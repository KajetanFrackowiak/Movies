package org.example.movies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "actors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    private ObjectId id;
    private String name;
    private String lastname;
    private String birthday;
    private String Genre;
    private String Nationality;
}
