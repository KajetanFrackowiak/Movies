package org.example.movies.Service;

import org.example.movies.Model.Movie;
import org.example.movies.Repostiory.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String imdbId) {
        Optional<Movie> movieOptional = movieRepository.findMovieByImdbId(imdbId);
        movieOptional.ifPresent(movie -> movieRepository.delete(movie));
    }
}
