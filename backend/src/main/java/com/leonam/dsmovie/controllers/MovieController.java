package com.leonam.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonam.dsmovie.dto.MovieDTO;
import com.leonam.dsmovie.services.MovieService;

//classe para implementar o endpoint
//configurar como controlador rest
@RestController
//mapear o caminho
@RequestMapping(value = "/movies")

public class MovieController {
	
	@Autowired
	private MovieService service;

	//configurar  
	@GetMapping
	
	//metodo de retorno
	public Page<MovieDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	//retornar um unico filme -------------------------------------------
	@GetMapping(value = "/{id}") //parametro de url no spring
	public MovieDTO findById(@PathVariable Long id){
		return service.findById(id);
	}


}
