package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.MatchRepo;
import com.javier.nbaspring.model.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepo matchRepo;

    @Override
    public List<Match> findAll() {
        return (List<Match>) matchRepo.findAll();
    }
}
