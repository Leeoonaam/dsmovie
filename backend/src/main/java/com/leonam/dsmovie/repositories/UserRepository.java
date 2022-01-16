package com.leonam.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.dsmovie.entities.User;

//criando repository
public interface UserRepository extends JpaRepository<User,Long> {
	//metodo que retorna um user de acordo com a busca do email
	User findByEmail(String email);
}
