package com.nadmad.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nadmad.dslist.entities.Game;
import com.nadmad.dslist.entities.dto.GameDTO;
import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = repository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		return new GameDTO(repository.findById(id).get());
	}
}
