package com.reto.service.impl;

import com.reto.model.Cabin;
import com.reto.repository.CabinRepository;
import com.reto.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabinServiceImpl implements CabinService {

    @Autowired
    public CabinRepository cabinRepository;

    @Override
    public List<Cabin> getCabin(){
        List<Cabin> response = new ArrayList<>();

        cabinRepository.findAll().forEach(response::add);

        return response;
    }

    @Override
    public Cabin postCabin(Cabin cabin) {
        cabinRepository.save(cabin);
        return cabin;
    }
}
