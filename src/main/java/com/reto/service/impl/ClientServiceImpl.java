package com.reto.service.impl;

import com.reto.model.Client;
import com.reto.repository.ClientRepository;
import com.reto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Client postClient(Client client) {

        if(client.getIdClient() == null){
            clientRepository.save(client);
        }else{
            Optional<Client> clientOptional = clientRepository.findById(client.getIdClient());
            if(clientOptional.isEmpty()){
                client = clientRepository.save(client);
            }else{
                client = clientOptional.get();
            }
        }
        return client;
    }



    @Override
    public Client putClient(Client client){
        if(client.getIdClient() != null){
            Optional<Client> clientOptional = clientRepository.findById(client.getIdClient());
            if(clientOptional.isPresent()){
                Client clientUpdate = clientOptional.get();
                clientUpdate.setEmail(client.getEmail() != null ? client.getEmail(): clientUpdate.getEmail());
                clientUpdate.setPassword(client.getPassword() != null ? client.getPassword(): clientUpdate.getPassword());
                clientUpdate.setName(client.getName() != null ? client.getName(): clientUpdate.getName());
                clientUpdate.setAge(client.getAge() != null ? client.getAge(): clientUpdate.getAge());
                clientUpdate.setMessages(client.getMessages() != null ? client.getMessages(): clientUpdate.getMessages());
                clientUpdate.setReservations(client.getReservations() != null ? client.getReservations(): clientUpdate.getReservations());

                client = clientRepository.save(clientUpdate);
            }
        }
        return client;
    }

    @Override
    public Optional<Client> getClientById(Integer idClient){
        return clientRepository.findById(idClient);
    }

    @Override
    public boolean deleteClient(Integer idClient){
        Boolean flag = clientRepository.findById(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);

        return flag;
    }

}
