package com.leonam.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.dsmovie.entities.Score;
import com.leonam.dsmovie.entities.ScorePK;

//criando repository
public interface ScoreRepository extends JpaRepository<Score,ScorePK> {

}
