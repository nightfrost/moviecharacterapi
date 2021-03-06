package com.example.moviecharacterapi.repositories;

import com.example.moviecharacterapi.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>  {

}
