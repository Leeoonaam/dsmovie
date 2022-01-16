package com.leonam.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.dsmovie.entities.Movie;

//criando repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
