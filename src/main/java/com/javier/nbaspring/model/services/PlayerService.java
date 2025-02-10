package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public List<Player> findAll();
    Optional<Player> findById(int id);
    Player save(Player player);
    void deleteById(Integer id);
    Player update(Integer id, Player player);
}
