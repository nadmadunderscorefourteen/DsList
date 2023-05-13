package com.nadmad.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadmad.dslist.entities.Game;
import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.repositories.GameRepository;

@Service
public class GameServices {

	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = repository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
