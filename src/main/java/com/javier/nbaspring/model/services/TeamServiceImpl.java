package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.TeamRepo;
import com.javier.nbaspring.model.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepo teamRepo;


    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepo.findAll();
    }

    @Override
    public Optional<Team> findById(String name) {
        return teamRepo.findById(name);
    }

    @Override
    public Team save(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public void deleteById(String name) {
        teamRepo.deleteById(name);
    }

    @Override
    public Team update(String name, Team team) {
        Optional<Team> existingTeam = teamRepo.findById(name);
        if (existingTeam.isPresent()) {
            Team updatedTeam = existingTeam.get();
            updatedTeam.setCity(team.getCity());
            updatedTeam.setConference(team.getConference());
            updatedTeam.setDivision(team.getDivision());
            return teamRepo.save(updatedTeam);
        } else {
            throw new RuntimeException("Team with name " + name + " not found");
        }
    }
}
