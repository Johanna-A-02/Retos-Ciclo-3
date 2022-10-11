package com.reto.service;

import com.reto.model.Client;
import com.reto.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    List<Message> getMessage();

    Message postMessage(Message message);
    Message putMessage(Message message);

    Optional<Message> getMessageById(Integer idMessage);

    boolean deleteMessage(Integer idMessage);
}
