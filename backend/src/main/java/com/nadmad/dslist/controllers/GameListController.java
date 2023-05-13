package com.nadmad.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadmad.dslist.entities.dto.GameListDTO;
import com.nadmad.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService listService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		return listService.findAll();
	}
	
	/*
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id) {
		return listService.findById(id);
	} */
}
