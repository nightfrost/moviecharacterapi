package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long directorId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;
}
