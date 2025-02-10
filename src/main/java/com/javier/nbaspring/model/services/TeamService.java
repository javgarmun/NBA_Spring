package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    public List<Team> findAll();

    Optional<Team> findById(String name);

    Team save(Team team);

    void deleteById(String name);

    Team update(String name, Team team);
}
