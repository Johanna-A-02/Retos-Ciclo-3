package com.reto.controller;

import com.reto.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/api/Message")
@CrossOrigin(origins = {"*"})
public interface MessageAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getMessage();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postMessage(@RequestBody Message message);
    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putMessage(@RequestBody Message message);

    @GetMapping(value = "/{idMessage}", produces = "application/json")
    ResponseEntity<?> getMessageById(@PathVariable(value = "idMessage") Integer idMessage);

    @DeleteMapping(value = "/{idMessage}")
    ResponseEntity<?> deleteMessage(@PathVariable(value = "idMessage")Integer idMessage);
}
