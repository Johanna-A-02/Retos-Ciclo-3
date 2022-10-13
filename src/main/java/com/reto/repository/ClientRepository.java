package com.reto.repository;

import com.reto.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT c FROM Client c WHERE c.idClient in (SELECT r.client.idClient FROM Reservation r where r.status =:status)")
    List<Client> findAllByStatus(@Param(value = "status") String status);

}
