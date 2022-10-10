package com.reto.controller;

import com.reto.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Client")
@CrossOrigin(origins = {"*"})
public interface ClientAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getClient();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postClient(@RequestBody Client client);

    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putClient(@RequestBody Client client);

    @GetMapping(value = "/{idClient}", produces = "application/json")
    ResponseEntity<?> getClientById(@PathVariable(value = "idClient") Integer idClient);

    @DeleteMapping(value = "/{idClient}")
    ResponseEntity<?> deleteClient(@PathVariable(value = "idClient")Integer idClient);
}
