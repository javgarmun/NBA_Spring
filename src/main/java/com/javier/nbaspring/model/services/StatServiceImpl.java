package com.javier.nbaspring.model.services;

import com.javier.nbaspring.model.dao.StatRepo;
import com.javier.nbaspring.model.entity.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatRepo statRepo;

    @Override
    public List<Stat> findAll() {
        return (List<Stat>) statRepo.findAll();
    }
}
