package com.reto.controller;

import com.reto.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/Reservation")
@CrossOrigin(origins = {"*"})
public interface ReservationAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getReservation();

    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postReservation(@RequestBody Reservation reservation);

    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putReservation(@RequestBody Reservation reservation);

    @GetMapping(value = "/{idReservation}", produces = "application/json")
    ResponseEntity<?> getReservationById(@PathVariable(value = "idReservation") Integer idReservation);

    @DeleteMapping(value = "/{idReservation}")
    ResponseEntity<?> deleteReservation(@PathVariable(value = "idReservation") Integer idReservation);

}
