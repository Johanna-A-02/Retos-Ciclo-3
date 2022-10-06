package com.reto.service;

import com.reto.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getReservation();

    String postReservation (Reservation reservation);

}
