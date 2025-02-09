package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Match;
import java.util.List;

public interface MatchService {
    public List<Match> findAll();
}
