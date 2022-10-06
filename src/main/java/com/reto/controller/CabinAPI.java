package com.reto.controller;

import com.reto.model.Cabin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Cabin")
public interface CabinAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getCabin();

    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postCabin(@RequestBody Cabin cabin);
}
