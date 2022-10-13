package com.reto.repository;

import com.reto.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT count(c) FROM Reservation c WHERE c.status = :status")
    int countByStatus(@Param(value = "status") String status);
}
