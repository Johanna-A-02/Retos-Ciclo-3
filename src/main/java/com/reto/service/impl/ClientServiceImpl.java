package com.reto.service.impl;

import com.reto.model.Client;
import com.reto.repository.ClientRepository;
import com.reto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClient(){
        List<Client> response = new ArrayList<>();
        clientRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public String postClient(Client client) {
        clientRepository.save(client);
        return "Guardado Éxitosamente!";
    }

}
