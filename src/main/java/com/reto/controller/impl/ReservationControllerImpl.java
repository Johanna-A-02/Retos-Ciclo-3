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

    @Override
    public ResponseEntity<?> putReservation(Reservation reservation) {
        ResponseEntity<?> response = new ResponseEntity(reservationService.putReservation(reservation), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getReservationById(Integer idReservation) {
        ResponseEntity<?> response = new ResponseEntity(reservationService.getReservationById(idReservation), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteReservation(Integer idReservation) {
        ResponseEntity<?> response = new ResponseEntity(reservationService.deleteReservation(idReservation), HttpStatus.NO_CONTENT);
        return response;
    }

    @Override
    public ResponseEntity<?> getReportStatus() {
        ResponseEntity<?> response = new ResponseEntity(reservationService.getReportStatus(), HttpStatus.OK);
        return response;
    }
}
