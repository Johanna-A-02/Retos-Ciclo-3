package com.reto.service;

import com.reto.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClient();

    String postClient(Client client);
}
