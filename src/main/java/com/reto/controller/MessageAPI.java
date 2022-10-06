package com.reto.controller;

import com.reto.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/api/Message")
public interface MessageAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getMessage();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postMessage(@RequestBody Message message);
}
