package com.reto.service;

import com.reto.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getClient();

    Client postClient(Client client);

    Client putClient(Client client);

    Optional<Client> getClientById(Integer idClient);

    boolean deleteClient(Integer idClient);
}
