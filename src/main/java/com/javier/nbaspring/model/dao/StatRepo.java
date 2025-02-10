package com.javier.nbaspring.model.dao;

import com.javier.nbaspring.model.entity.Stat;
import com.javier.nbaspring.model.entity.StatId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatRepo extends CrudRepository<Stat, StatId> {
    // Obtiene las stats de un jugador
    List<Stat> findByPlayer_Id(Integer playerId);

    // Obtiene las stats de un jugador concreto en una temporada específica
    Stat findById_PlayerAndId_Season(Integer playerId, String seasonId);
}
