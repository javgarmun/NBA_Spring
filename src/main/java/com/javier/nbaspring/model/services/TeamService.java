package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Team;

import java.util.List;

public interface TeamService {
    public List<Team> findAll();
}
