package com.reto.controller.impl;

import com.reto.controller.ClientAPI;
import com.reto.model.Client;
import com.reto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControllerImpl implements ClientAPI {

    @Autowired
    private ClientService clientService;

    @Override
    public ResponseEntity<?> getClient(){
        ResponseEntity<?> response = new ResponseEntity(clientService.getClient(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postClient(Client client) {
        ResponseEntity<?> response = new ResponseEntity(clientService.postClient(client), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> putClient(Client client) {
        ResponseEntity<?> response = new ResponseEntity(clientService.putClient(client), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getClientById(Integer idClient) {
        ResponseEntity<?> response = new ResponseEntity(clientService.getClientById(idClient), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteClient(Integer idClient) {
        ResponseEntity<?> response = new ResponseEntity(clientService.deleteClient(idClient), HttpStatus.NO_CONTENT);
        return response;
    }

}
