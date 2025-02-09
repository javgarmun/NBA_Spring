package com.javier.nbaspring.model.dao;

import com.javier.nbaspring.model.entity.Stat;
import org.springframework.data.repository.CrudRepository;

public interface StatRepo extends CrudRepository<Stat, Integer> {

}
