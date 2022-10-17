package com.reto.repository;

import com.reto.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT count(c) FROM Reservation c WHERE c.status = :status")
    int countByStatus(@Param(value = "status") String status);

    @Modifying
    @Query(value = "DELETE FROM Reservation c WHERE c.idReservation = :idReservation")
    void deleteById(@Param(value = "idReservation") Integer idReservation);
    @Query(value = "SELECT c FROM Reservation c WHERE c.startDate BETWEEN :startDate AND :endDate")
    List<Reservation> findAllBetweenDates(@Param(value = "startDate")Timestamp startDate, @Param(value = "endDate")Timestamp endDate);
}
