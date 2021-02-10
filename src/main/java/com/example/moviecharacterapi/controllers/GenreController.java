package com.example.moviecharacterapi.controllers;


import com.example.moviecharacterapi.models.Genre;
import com.example.moviecharacterapi.repositories.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
public class GenreController {

    public GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Genre>> getAllGenres() {
        HttpStatus status;
        List<Genre> genres = genreRepository.findAll();
        if (genres.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(genres, status);
    }
}

