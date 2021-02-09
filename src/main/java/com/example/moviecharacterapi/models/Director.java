package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long directorId;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name="movie_has_director",
            joinColumns={@JoinColumn(name="directorId")},
            inverseJoinColumns={@JoinColumn(name="movieId")}
    )
    private Set<Movie> movies;
}
