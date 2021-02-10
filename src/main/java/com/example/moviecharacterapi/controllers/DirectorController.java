package com.example.moviecharacterapi.controllers;


import com.example.moviecharacterapi.models.Director;
import com.example.moviecharacterapi.repositories.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;
    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Director>> getAllDirectors() {
        HttpStatus status;
        List<Director> directors = directorRepository.findAll();
        if (directors.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status =HttpStatus.OK;
        }
        return new ResponseEntity<>(directors, status);
    }
}
