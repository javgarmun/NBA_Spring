package com.javier.nbaspring.controllers;

import com.javier.nbaspring.model.entity.Player;
import com.javier.nbaspring.model.entity.Stat;
import com.javier.nbaspring.model.entity.StatId;
import com.javier.nbaspring.model.services.PlayerService;
import com.javier.nbaspring.model.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/nba/players")
public class StatRestController {
    @Autowired
    private StatService statService;

    @Autowired
    private PlayerService playerService;

    // GET /nba/players/{id}/stats - Obtener todas las estadísticas de un jugador
    @GetMapping("/{id}/stats")
    public ResponseEntity<List<Stat>> getStatsByPlayer(@PathVariable Integer id) {
        List<Stat> stats = statService.findByPlayerId(id);
        if (stats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(stats, HttpStatus.OK);
        }
    }

    // POST /nba/players/{id}/stats - Crear una nueva estadística para un jugador
    @PostMapping("/{id}/stats")
    public ResponseEntity<Stat> createStat(@PathVariable Integer id, @RequestBody Stat stat) {
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()) {
            stat.setPlayer(player.get());
            stat.getId().setPlayer(id); // Establece el ID del jugador en la clave compuesta
            Stat savedStat = statService.save(stat);
            return new ResponseEntity<>(savedStat, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET /nba/players/{id}/stats/{season} - Obtener una estadística específica en una season
    @GetMapping("/{id}/stats/{season}")
    public ResponseEntity<Stat> updateStat(@PathVariable Integer id, @PathVariable String season) {
        Optional<Stat> stat = statService.findByPlayerIdAndSeasonId(id, season);
        return stat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT /nba/players/{id}/stats/{season} - Actualizar una estadística específica
    @PutMapping("/{id}/stats/{season}")
    public ResponseEntity<Stat> updateStat(@PathVariable Integer id, @PathVariable String season, @RequestBody Stat stat) {
        StatId statId = new StatId();
        statId.setPlayer(id);
        statId.setSeason(season);
        try {
            Stat updatedStat = statService.update(statId, stat);
            return new ResponseEntity<>(updatedStat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /nba/players/{id}/stats/{season} - Eliminar una estadística específica
    @DeleteMapping("/{id}/stats/{season}")
    public ResponseEntity<Stat> deleteStat(@PathVariable Integer id, @PathVariable String season) {
        StatId statId = new StatId();
        statId.setPlayer(id);
        statId.setSeason(season);
        Optional<Stat> stat = statService.findByPlayerIdAndSeasonId(id, season);
        if (stat.isPresent()) {
            statService.deleteById(statId);
            return new ResponseEntity<>(stat.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
