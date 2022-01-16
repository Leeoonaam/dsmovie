package com.leonam.dsmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//shift + Ctrl + O para importar
@Entity

//especificar tabela
@Table(name = "tb_movie")

public class Movie {
	
	//chave primaria
	@Id
	//configurar o id auto encrementável no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	//atributos com tipo de dados classe
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	//construtor para instanciar
	public Movie() {
		
	}

	//construtor que recebe argumentos
	public Movie(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
	}

	//gets e sets ---------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
