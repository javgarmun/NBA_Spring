package com.javier.nbaspring.controllers;

import com.javier.nbaspring.model.entity.Match;
import com.javier.nbaspring.model.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MatchRestController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchService.findAll();
    }
}
