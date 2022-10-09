package com.reto.controller;

import com.reto.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/Message")
@CrossOrigin(origins = {"*"})
public interface MessageAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getMessage();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postMessage(@RequestBody Message message);
}
