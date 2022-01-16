package com.leonam.dsmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//shift + Ctrl + O para importar
@Entity

//especificar tabela
@Table(name = "tb_user")

public class User {

	//chave primaria
	@Id
	//configurar o id auto encrementável no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	//atributos com tipo de dados classe
	private Long id;
	private String email;
	
	//construtor para instanciar
	public User() {
		
	}

	//construtor que recebe argumentos
	public User(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	//gets e sets ---------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
