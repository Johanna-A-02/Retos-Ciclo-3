package com.reto.controller;

import com.reto.model.AdminUser;
import com.reto.model.Cabin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/Cabin")
@CrossOrigin(origins = {"*"})
public interface CabinAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getCabin();

    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postCabin(@RequestBody Cabin cabin);

    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putCabin(@RequestBody Cabin cabin);

    @GetMapping(value = "/{idCabin}", produces = "application/json")
    ResponseEntity<?> getCabinById(@PathVariable(value = "idCabin") Integer idCabin);

    @DeleteMapping(value = "/{idCabin}")
    ResponseEntity<?> deleteCabin(@PathVariable(value = "idCabin")Integer idCabin);
}
