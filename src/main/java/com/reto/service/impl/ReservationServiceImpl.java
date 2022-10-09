package com.reto.service.impl;

import com.reto.model.Reservation;
import com.reto.repository.ReservationRepository;
import com.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservation(){
        List<Reservation> response = new ArrayList<>();
        reservationRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public Reservation postReservation(Reservation reservation){
        reservationRepository.save(reservation);
        return reservation;
    }
}
