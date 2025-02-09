package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.PlayerRepo;
import com.javier.nbaspring.model.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepo.findAll();
    }
}
