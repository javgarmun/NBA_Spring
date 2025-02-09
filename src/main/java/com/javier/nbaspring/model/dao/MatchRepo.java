package com.javier.nbaspring.model.dao;

import com.javier.nbaspring.model.entity.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepo extends CrudRepository<Match, Integer> {

}
