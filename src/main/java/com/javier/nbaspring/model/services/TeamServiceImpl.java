package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.PlayerRepo;
import com.javier.nbaspring.model.dao.TeamRepo;
import com.javier.nbaspring.model.entity.Player;
import com.javier.nbaspring.model.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private PlayerRepo playerRepo;


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

    // Manejo de jugadores
    @Override
    public List<Player> getPlayersByTeam(String teamName) {
        Optional<Team> team = teamRepo.findById(teamName);
        return team.map(Team::getPlayers).orElse(List.of());
    }

    @Override
    public Player addPlayerToTeam(String teamName, Player player) {
        Optional<Team> team = teamRepo.findById(teamName);
        if (team.isPresent()) {
            player.setTeamName(team.get());
            return playerRepo.save(player);
        } else {
            throw new RuntimeException("Team with name " + teamName + " not found");
        }
    }
}
