package com.javier.nbaspring.controllers;

import com.javier.nbaspring.model.entity.Team;
import com.javier.nbaspring.model.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TeamRestController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }
}
