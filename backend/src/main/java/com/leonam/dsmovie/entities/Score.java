package com.leonam.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

//shift + Ctrl + O para importar
@Entity

//especificar tabela
@Table(name = "tb_score")

public class Score {

	@EmbeddedId
	
	private ScorePK id = new ScorePK(); //chave composta
	private Double value; //atributo com tipo de dados classe
	
	//construtor para instanciar
	public Score() {
		
	}
	
	//metodo set para informar o filme e associar com o score
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	//metodo set para informar o usuario e associar com o score
	public void setUser(User user) {
		id.setUser(user);
	}

	//gets e sets ---------------------------
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
