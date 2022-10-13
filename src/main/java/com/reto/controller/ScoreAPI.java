package com.reto.controller;

import com.reto.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
