package com.reto.service.impl;

import com.reto.model.Client;
import com.reto.model.ReportClient;
import com.reto.model.ReportStatus;
import com.reto.model.Reservation;
import com.reto.repository.ClientRepository;
import com.reto.repository.ReservationRepository;
import com.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Reservation> getReservation() {
        List<Reservation> response = reservationRepository.findAll();
        return response;
    }

    @Override
    public Reservation postReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            reservation.setStatus("created");
            reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationOptional = reservationRepository.findById(reservation.getIdReservation());
            if (reservationOptional.isEmpty()) {
                reservation.setStatus("created");
                reservation = reservationRepository.save(reservation);
            } else {
                reservation = reservationOptional.get();
            }
        }
        return reservation;
    }

    @Override
    public Reservation putReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationOptional = reservationRepository.findById(reservation.getIdReservation());
            if (reservationOptional.isPresent()) {
                Reservation updatedReservation = reservationOptional.get();
                updatedReservation.setStatus(reservation.getStatus() != null ? reservation.getStatus() : updatedReservation.getStatus());
                updatedReservation.setStartDate(reservation.getStartDate() != null ? reservation.getStartDate() : updatedReservation.getStartDate());
                updatedReservation.setDevolutionDate(reservation.getDevolutionDate() != null ? reservation.getDevolutionDate() : updatedReservation.getDevolutionDate());
                updatedReservation.setScore(reservation.getScore() != null ? reservation.getScore() : updatedReservation.getScore());
                updatedReservation.setCabin(reservation.getCabin() != null ? reservation.getCabin() : updatedReservation.getCabin());
                updatedReservation.setClient(reservation.getClient() != null ? reservation.getClient() : updatedReservation.getClient());

                if (updatedReservation.getScore() != null) {
                    updatedReservation.getScore().setReservation(updatedReservation);
                }
                reservation = reservationRepository.save(updatedReservation);
            }
        }
        return reservation;
    }

    @Override
    public Optional<Reservation> getReservationById(Integer idReservation) {
        return reservationRepository.findById(idReservation);
    }

    @Override
    @Transactional
    public boolean deleteReservation(Integer idReservation) {
        Boolean flag = reservationRepository.findById(idReservation).map(reservation -> {
            reservationRepository.deleteById(reservation.getIdReservation());
            return true;
        }).orElse(false);

        return flag;
    }

    @Override
    public List<Reservation> getReportDate(Timestamp startDate, Timestamp endDate) {
        List<Reservation> reservationList = reservationRepository.findAllBetweenDates(startDate, endDate);
        return reservationList;
    }

    @Override
    public List<ReportClient> getReportClient() {
        List<Client> response = clientRepository.findAllByStatus("completed");
        final List<ReportClient> responseList = new ArrayList<>();


        response.forEach(client -> {
            final ReportClient reportClient = new ReportClient();
            reportClient.setTotal(client.getReservations() != null ? (int) client.getReservations().stream().filter(r -> r.getStatus().equals("completed")).count() : 0);
            reportClient.setClient(client);
            responseList.add(reportClient);
        });

        responseList.sort(Comparator.comparing(ReportClient::getTotal).reversed());

        return responseList;
    }

    @Override
    public ReportStatus getReportStatus(){
        final int canceladas = reservationRepository.countByStatus("cancelled");
        final int completed = reservationRepository.countByStatus("completed");

        final ReportStatus reportStatus = new ReportStatus();
        reportStatus.setCancelled(canceladas);
        reportStatus.setCompleted(completed);

        return reportStatus;
    }

}
