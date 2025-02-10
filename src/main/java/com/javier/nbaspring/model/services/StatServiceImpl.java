package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.StatRepo;
import com.javier.nbaspring.model.entity.Stat;
import com.javier.nbaspring.model.entity.StatId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatRepo statRepo;

    @Override
    public List<Stat> findByPlayerId(Integer playerId) {
        return statRepo.findByPlayer_Id(playerId);
    }

    @Override
    public Optional<Stat> findByPlayerIdAndSeasonId(Integer playerId, String seasonId) {
        Stat stat = statRepo.findById_PlayerAndId_Season(playerId, seasonId);
        return Optional.ofNullable(stat);
    }

    @Override
    public Stat save(Stat stat) {
        return statRepo.save(stat);
    }

    @Override
    public void deleteById(StatId statId) {
        statRepo.deleteById(statId);
    }

    @Override
    public Stat update(StatId statId, Stat updatedStat) {
        Optional<Stat> existingStat = statRepo.findById(statId);
        if (existingStat.isPresent()) {
            Stat stat = existingStat.get();
            stat.setPointsPerMatch(updatedStat.getPointsPerMatch());
            stat.setAssistancesPerMatch(updatedStat.getAssistancesPerMatch());
            stat.setBlocksPerMatch(updatedStat.getBlocksPerMatch());
            stat.setReboundPerMatch(updatedStat.getReboundPerMatch());
            return statRepo.save(stat);
        } else {
            throw new RuntimeException("Stat not found for player " + statId.getPlayer() + " and season " + statId.getSeason());
        }
    }
}
