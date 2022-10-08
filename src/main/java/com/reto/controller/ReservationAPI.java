package com.reto.controller;

import com.reto.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/Reservation")
@CrossOrigin(origins = {"*"})
public interface ReservationAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getReservation();

    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postReservation(@RequestBody Reservation reservation);
}
