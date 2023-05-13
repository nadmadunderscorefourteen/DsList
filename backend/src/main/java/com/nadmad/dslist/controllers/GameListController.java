package com.nadmad.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadmad.dslist.entities.dto.GameListDTO;
import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.services.GameListService;
import com.nadmad.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService listService;
	
	@Autowired
	private GameService gService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		return listService.findAll();
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		return gService.findByList(listId);
	}
}
