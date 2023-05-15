package com.nadmad.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nadmad.dslist.entities.Game;
import com.nadmad.dslist.entities.GameList;
import com.nadmad.dslist.entities.dto.GameDTO;
import com.nadmad.dslist.entities.dto.GameListDTO;
import com.nadmad.dslist.entities.dto.GameMinDTO;
import com.nadmad.dslist.projections.GameMinProjection;
import com.nadmad.dslist.repositories.GameListRepository;
import com.nadmad.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository listRepository;
	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = listRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
		
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = repository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
