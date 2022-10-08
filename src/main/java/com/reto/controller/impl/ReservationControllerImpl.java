package com.reto.controller.impl;

import com.reto.controller.ReservationAPI;
import com.reto.model.Reservation;
import com.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationControllerImpl implements ReservationAPI {

    @Autowired
    private ReservationService reservationService;

    @Override
    public ResponseEntity<?> getReservation(){
        ResponseEntity<?> response = new ResponseEntity(reservationService.getReservation(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postReservation(Reservation reservation){
        ResponseEntity<?> response = new ResponseEntity(reservationService.postReservation(reservation), HttpStatus.CREATED);
        return response;
    }
}
