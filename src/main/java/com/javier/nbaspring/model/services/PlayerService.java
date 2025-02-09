package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> findAll();
}
