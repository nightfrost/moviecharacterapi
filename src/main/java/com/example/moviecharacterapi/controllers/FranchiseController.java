package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Franchise;
import com.example.moviecharacterapi.repositories.FranchiseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/V1/franchise")
public class FranchiseController {
    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseRepository franchiseRepository, FranchiseRepository franchiseRepository1) {
        this.franchiseRepository = franchiseRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        HttpStatus status;
        List<Franchise> franchises = franchiseRepository.findAll();
        if (franchises.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(franchises, status);
    }
}
