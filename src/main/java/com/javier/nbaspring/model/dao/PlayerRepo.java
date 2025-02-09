package com.javier.nbaspring.model.dao;

import com.javier.nbaspring.model.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, Integer> {

}
