package com.reto.controller;

import com.reto.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Score")
public interface ScoreAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getScore();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postScore(@RequestBody Score score);
}
