package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Franchise;
import com.example.moviecharacterapi.repositories.FranchiseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getLibrary(@PathVariable Long id){
        Franchise returnFranchise = new Franchise();
        HttpStatus status;
        // We first check if the Library exists, this saves some computing time.
        if(franchiseRepository.existsById(id)){
            status = HttpStatus.OK;
            returnFranchise = franchiseRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnFranchise, status);
    }

    @PostMapping
    public ResponseEntity<Franchise> addLibrary(@RequestBody Franchise franchise){
        Franchise returnFranchise = franchiseRepository.save(franchise);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnFranchise, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateLibrary(@PathVariable Long id, @RequestBody Franchise franchise){
        Franchise returnFranchise = new Franchise();
        HttpStatus status;
        if(!id.equals(franchise.getFranchiseId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFranchise,status);
        }
        returnFranchise = franchiseRepository.save(franchise);
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnFranchise, status);
    }

    //Deletes the character but returns 500 Internal error???
    @DeleteMapping("/{id}")
    public ResponseEntity<Franchise> deleteFranchise(@PathVariable long id) {
        // checks if it exists
        if (franchiseRepository.existsById(id)) {
            Franchise franchise = franchiseRepository.findById(id).get();
            franchiseRepository.delete(franchise);
            return new ResponseEntity<>(franchise, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
