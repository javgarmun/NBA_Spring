package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.TeamRepo;
import com.javier.nbaspring.model.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepo teamRepo;


    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepo.findAll();
    }
}
