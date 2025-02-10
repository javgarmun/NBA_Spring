package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Stat;
import com.javier.nbaspring.model.entity.StatId;

import java.util.List;
import java.util.Optional;

public interface StatService {
    List<Stat> findByPlayerId(Integer playerId);

    Optional<Stat> findByPlayerIdAndSeasonId(Integer id, String seasonId);

    Stat save(Stat stat);

    void deleteById(StatId statId);

    Stat update(StatId statId, Stat stat);
}
