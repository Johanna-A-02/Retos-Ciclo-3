package com.reto.controller.impl;

import com.reto.controller.MessageAPI;
import com.reto.model.Message;
import com.reto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageControllerImpl implements MessageAPI {

    @Autowired
    private MessageService messageService;

    @Override
    public ResponseEntity<?> getMessage(){

        ResponseEntity<?> response = new ResponseEntity(messageService.getMessage(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postMessage(Message message) {

        ResponseEntity<?> response = new ResponseEntity(messageService.postMessage(message), HttpStatus.CREATED);
        return response;
    }
    @Override
    public ResponseEntity<?> putMessage(Message message) {
        ResponseEntity<?> response = new ResponseEntity(messageService.putMessage(message), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getMessageById(Integer idMessage) {
        ResponseEntity<?> response = new ResponseEntity(messageService.getMessageById(idMessage), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteMessage(Integer idMessage) {
        ResponseEntity<?> response = new ResponseEntity(messageService.deleteMessage(idMessage), HttpStatus.NO_CONTENT);
        return response;
    }
}