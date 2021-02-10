package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    //CRUD
    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies() {
        HttpStatus status;
        List<Movie> movies = movieRepository.findAll();
        if (movies.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(movies, status);
    }

}
