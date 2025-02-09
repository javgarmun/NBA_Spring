package com.javier.nbaspring.model.dao;

import com.javier.nbaspring.model.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository<Team, Integer> {

}
