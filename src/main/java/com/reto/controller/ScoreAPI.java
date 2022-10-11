package com.reto.controller;

import com.reto.model.Client;
import com.reto.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/Score")
@CrossOrigin(origins = {"*"})
public interface ScoreAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getScore();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postScore(@RequestBody Score score);
    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putScore(@RequestBody Score score);

    @GetMapping(value = "/{idScore}", produces = "application/json")
    ResponseEntity<?> getScoreById(@PathVariable(value = "idScore") Integer idScore);

    @DeleteMapping(value = "/{idScore}")
    ResponseEntity<?> deleteScore(@PathVariable(value = "idScore")Integer idScore);
}
