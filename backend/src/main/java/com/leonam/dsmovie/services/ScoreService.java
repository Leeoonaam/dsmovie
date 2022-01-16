package com.leonam.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonam.dsmovie.dto.MovieDTO;
import com.leonam.dsmovie.dto.ScoreDTO;
import com.leonam.dsmovie.entities.Movie;
import com.leonam.dsmovie.entities.Score;
import com.leonam.dsmovie.entities.User;
import com.leonam.dsmovie.repositories.MovieRepository;
import com.leonam.dsmovie.repositories.ScoreRepository;
import com.leonam.dsmovie.repositories.UserRepository;

//importar para registrar como componente do sistema - esse registro é necessário quando a classe é customizada
@Service
public class ScoreService {
	
	//Quando se faz um sistema que já contem o gerenciamento de dependências como esse, não precisa instanciar
	//os objetos manualmente, então sempre quando precisar de um objeto é só declarar a composição do componente
	@Autowired
	
	//Composiçao - objeto responsavel para acessar o banco de dados
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	//salvar um novo score no banco de dados a partir do objeto scoredto no controlador
	public MovieDTO saveScore(ScoreDTO dto) {
		//busca no banco de dados o usuario por email e guardo na variavel
		User user = userRepository.findByEmail(dto.getEmail());
		
		//verifica se está vazio
		if(user == null) {
			user = new User(); //instancia
			user.setEmail(dto.getEmail()); //set email
			user = userRepository.saveAndFlush(user); //salva no banco passando o usuario - saveAndFlush garante que tem o objeto atualizado
		}
		
		//captura o id
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score(); //instancia vazio
		score.setMovie(movie); // recebe movie
		score.setUser(user); //recebe user
		score.setValue(dto.getScore()); //recebe valor do score
		
		//salva
		score = scoreRepository.saveAndFlush(score);
		
		//variavel para somar avalizações
		double sum = 0.0;
		
		//loop para percorrer todos os scores do filme
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue(); //soma os valores
		}
		
		//media das avalizações
		double avg = sum / movie.getScores().size(); //size pega o tamanho da coleção
		
		movie.setScore(avg); //soma divida pela quantidade
		movie.setCount(movie.getScores().size()); //count é o size
		
		//salva movie
		movie = movieRepository.save(movie);
		
		//retorna convertendo em DTO
		return new MovieDTO(movie);
	}
	
}
