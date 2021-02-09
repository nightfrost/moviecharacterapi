package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    @Column(name="type")
    private String type;

    @ManyToMany
    public Set<Movie> movies;
}
