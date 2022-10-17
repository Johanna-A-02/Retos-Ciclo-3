package com.reto.service;

import com.reto.model.ReportClient;
import com.reto.model.ReportStatus;
import com.reto.model.Reservation;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservation();

    Reservation postReservation (Reservation reservation);

    Reservation putReservation(Reservation reservation);

    Optional<Reservation> getReservationById(Integer idReservation);

    boolean deleteReservation(Integer idReservation);

    List<Reservation> getReportDate(Timestamp startDate, Timestamp endDate);

    ReportStatus getReportStatus();

    List<ReportClient> getReportClient();

}
