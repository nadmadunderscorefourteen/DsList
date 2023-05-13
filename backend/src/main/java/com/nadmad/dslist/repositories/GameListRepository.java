package com.nadmad.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadmad.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
