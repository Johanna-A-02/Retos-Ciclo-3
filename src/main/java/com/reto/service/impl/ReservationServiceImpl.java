package com.reto.service.impl;

import com.reto.model.Reservation;
import com.reto.repository.ReservationRepository;
import com.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservation(){
        List<Reservation> response = reservationRepository.findAll();
        return response;
    }

    @Override
    public Reservation postReservation(Reservation reservation){
        if(reservation.getIdReservation() == null){
            reservation.setStatus("created");
            reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reservationOptional = reservationRepository.findById(reservation.getIdReservation());
            if(reservationOptional.isEmpty()){
                reservation.setStatus("created");
                reservation = reservationRepository.save(reservation);
            }else{
                reservation = reservationOptional.get();
            }
        }
        return reservation;
    }

    @Override
    public Reservation putReservation(Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> reservationOptional = reservationRepository.findById(reservation.getIdReservation());
            if(reservationOptional.isPresent()){
                Reservation updatedReservation = reservationOptional.get();
                updatedReservation.setStatus(reservation.getStatus() != null ? reservation.getStatus(): updatedReservation.getStatus());
                updatedReservation.setStartDate(reservation.getStartDate() != null ? reservation.getStartDate(): updatedReservation.getStartDate());
                updatedReservation.setDevolutionDate(reservation.getDevolutionDate() != null ? reservation.getDevolutionDate(): updatedReservation.getDevolutionDate());
                updatedReservation.setScore(reservation.getScore() != null ? reservation.getScore(): updatedReservation.getScore());
                updatedReservation.setCabin(reservation.getCabin() != null ? reservation.getCabin(): updatedReservation.getCabin());
                updatedReservation.setClient(reservation.getClient() != null ? reservation.getClient(): updatedReservation.getClient());

                reservation = reservationRepository.save(updatedReservation);
            }
        }
        return reservation;
    }

    @Override
    public Optional<Reservation> getReservationById(Integer idReservation){
        return reservationRepository.findById(idReservation);
    }

    @Override
    public boolean deleteReservation(Integer idReservation){
        Boolean flag = reservationRepository.findById(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);

        return flag;
    }
}
