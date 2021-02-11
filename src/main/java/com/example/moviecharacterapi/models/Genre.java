package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    @Column(name="type")
    private String type;

    @ManyToMany
    @JoinTable(name = "movie_Has_Genre",
            joinColumns = {@JoinColumn(name = "genreId")},
            inverseJoinColumns = {@JoinColumn(name = "movieId")}
    )

    public Set<Movie> movies;


    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
