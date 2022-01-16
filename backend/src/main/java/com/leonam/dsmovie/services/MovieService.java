package com.leonam.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonam.dsmovie.dto.MovieDTO;
import com.leonam.dsmovie.entities.Movie;
import com.leonam.dsmovie.repositories.MovieRepository;

//importar para registrar como componente do sistema - esse registro é necessário quando a classe é customizada
@Service
public class MovieService {
	
	//Quando se faz um sistema que já contem o gerenciamento de dependências como esse, não precisa instanciar
	//os objetos manualmente, então sempre quando precisar de um objeto é só declarar a composição do componente
	@Autowired
	
	//Composiçao - objeto responsavel para acessar o banco de dados
	private MovieRepository repository;
	
	//Garante a transação jpa da camada de serviço
	//Propriedade somente para leitura acrescenta readOnly = true
	@Transactional(readOnly = true)
	
	//busca filmes retornando dados em DTO
	public Page<MovieDTO> findAll(Pageable pageable) {
		//chamar o banco de dados - desse forma retornara uma pagina de filmes e não uma lista(List<Movie>)
		Page<Movie> result = repository.findAll(pageable);
		//converter em DTO
		//map é para aplicar a função em cada elemento da lista
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		//retorna o valor
		return page;
	}
	
	//buscar um unico filme -------------------------------------------
	@Transactional(readOnly = true)
	
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
