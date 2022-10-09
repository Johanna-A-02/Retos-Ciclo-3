package com.reto.service;

import com.reto.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClient();

    Client postClient(Client client);

    String putClient(Client client);

    String deleteClient(Client client);
}
