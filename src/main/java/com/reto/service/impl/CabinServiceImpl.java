package com.reto.service.impl;

import com.reto.model.AdminUser;
import com.reto.model.Cabin;
import com.reto.repository.CabinRepository;
import com.reto.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CabinServiceImpl implements CabinService {

    @Autowired
    public CabinRepository cabinRepository;

    @Override
    public List<Cabin> getCabin(){
        List<Cabin> response = cabinRepository.findAll();
        return response;
    }

    @Override
    public Cabin postCabin(Cabin cabin) {

        if(cabin.getId() == null){
            cabinRepository.save(cabin);
        }else{
            Optional<Cabin> cabinOptional = cabinRepository.findById(cabin.getId());
            if(cabinOptional.isEmpty()){
                cabin = cabinRepository.save(cabin);
            }else{
                cabin = cabinOptional.get();
            }
        }
        return cabin;
    }
}
