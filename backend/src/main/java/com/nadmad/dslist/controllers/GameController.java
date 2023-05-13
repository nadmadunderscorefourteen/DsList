package com.nadmad.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadmad.dslist.entities.dto.GameDTO;
import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService services;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		return services.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		return services.findById(id);
	}
}
