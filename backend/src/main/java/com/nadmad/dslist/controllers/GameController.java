package com.nadmad.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameServices services;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		return services.findAll();
	}
}
