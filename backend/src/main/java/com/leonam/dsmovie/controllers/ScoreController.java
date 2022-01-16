package com.leonam.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonam.dsmovie.dto.MovieDTO;
import com.leonam.dsmovie.dto.ScoreDTO;
import com.leonam.dsmovie.services.ScoreService;

//classe para implementar o endpoint
//configurar como controlador rest
@RestController
//mapear o caminho
@RequestMapping(value = "/scores")

public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	//retornar um unico filme -------------------------------------------
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){ //annotation requestbody para configurar e ser capturado para conversão do dto
		MovieDTO dto2 = service.saveScore(dto);
		return dto2;
	}


}
