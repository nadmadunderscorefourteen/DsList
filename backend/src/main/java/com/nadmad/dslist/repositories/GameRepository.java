package com.nadmad.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadmad.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
