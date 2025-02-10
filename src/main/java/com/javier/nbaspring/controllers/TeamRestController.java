package com.javier.nbaspring.controllers;

import com.javier.nbaspring.model.entity.Team;
import com.javier.nbaspring.model.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/nba/teams")
public class TeamRestController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.findAll();
        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    // GET /nba/teams/{name} - Obtener un equipo por su nombre
    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeam(@PathVariable String name) {
        Optional<Team> team = teamService.findById(name);
        return team.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /nba/teams - Crear un nuevo equipo
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        try {
            Team savedTeam = teamService.save(team);
            return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT /nba/teams/{name} - Actualizar un equipo
    @PutMapping("/{name}")
    public ResponseEntity<Team> updateTeam(@PathVariable String name, @RequestBody Team team) {
        try {
            Team updatedTeam = teamService.update(name, team);
            return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /nba/teams/{name} - Eliminar un equipo
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String name) {
        Optional<Team> team = teamService.findById(name);
        if (team.isPresent()) {
            teamService.deleteById(name);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
