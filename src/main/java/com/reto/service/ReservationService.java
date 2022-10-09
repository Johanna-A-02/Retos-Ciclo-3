package com.reto.service;

import com.reto.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservation();

    Reservation postReservation (Reservation reservation);

    Reservation putReservation(Reservation reservation);

    Optional<Reservation> getReservationById(Integer idReservation);

    boolean deleteReservation(Integer idReservation);

}
