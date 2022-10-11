package com.reto.service.impl;


import com.reto.model.Cabin;
import com.reto.repository.CabinRepository;
import com.reto.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Cabin putCabin(Cabin cabin){
        if(cabin.getId() != null){
            Optional<Cabin> cabinOptional = cabinRepository.findById(cabin.getId());
            if(cabinOptional.isPresent()){
                Cabin cabinUpdate = cabinOptional.get();
                cabinUpdate.setName(cabin.getName() != null ? cabin.getName(): cabinUpdate.getName());
                cabinUpdate.setBrand(cabin.getBrand() != null ? cabin.getBrand(): cabinUpdate.getBrand());
                cabinUpdate.setRooms(cabin.getRooms() != null ? cabin.getRooms(): cabinUpdate.getRooms());
                cabinUpdate.setDescription(cabin.getDescription() != null ? cabin.getDescription(): cabinUpdate.getDescription());
                cabinUpdate.setCategory(cabin.getCategory() != null ? cabin.getCategory(): cabinUpdate.getCategory());
                cabinUpdate.setMessages(cabin.getMessages() != null ? cabin.getMessages(): cabinUpdate.getMessages());
                cabinUpdate.setReservations(cabin.getReservations() != null ? cabin.getReservations(): cabinUpdate.getReservations());


                cabin = cabinRepository.save(cabinUpdate);
            }
        }
        return cabin;
    }

    @Override
    public Optional<Cabin> getCabinById(Integer idCabin){
        return cabinRepository.findById(idCabin);
    }

    @Override
    public boolean deleteCabin(Integer idCabin){
        Boolean flag = cabinRepository.findById(idCabin).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);

        return flag;
    }
}
