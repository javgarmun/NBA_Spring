package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.PlayerRepo;
import com.javier.nbaspring.model.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepo.findAll();
    }

    @Override
    public Optional<Player> findById(int id) {
        return playerRepo.findById(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public void deleteById(Integer id) {
        playerRepo.deleteById(id);
    }

    @Override
    public Player update(Integer id, Player player) {
        Optional<Player> existingPlayer = playerRepo.findById(id);
        if (existingPlayer.isPresent()) {
            Player updatedPlayer = existingPlayer.get();
            updatedPlayer.setName(player.getName());
            updatedPlayer.setOrigin(player.getOrigin());
            updatedPlayer.setHeight(player.getHeight());
            updatedPlayer.setWeight(player.getWeight());
            updatedPlayer.setPosition(player.getPosition());
            updatedPlayer.setTeamName(player.getTeamName());
            updatedPlayer.setSalary(player.getSalary());
            return playerRepo.save(updatedPlayer);
        } else {
            throw new RuntimeException("Player with ID " + id + " not found.");
        }
    }
}
