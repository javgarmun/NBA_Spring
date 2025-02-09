package com.javier.nbaspring.controllers;

import com.javier.nbaspring.model.entity.Stat;
import com.javier.nbaspring.model.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StatRestController {
    @Autowired
    private StatService statService;

    @GetMapping("/stats")
    public List<Stat> getAllStats() {
        return statService.findAll();
    }
}
