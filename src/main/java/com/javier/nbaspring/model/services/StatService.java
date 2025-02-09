package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.entity.Stat;

import java.util.List;

public interface StatService {
    public List<Stat> findAll();
}
