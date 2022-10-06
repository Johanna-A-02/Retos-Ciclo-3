package com.reto.service.impl;

import com.reto.model.Message;
import com.reto.repository.MessageRepository;
import com.reto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessage (){
        List<Message> response = new ArrayList<>();
        messageRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public String postMessage(Message message) {
        messageRepository.save(message);
        return "Guardado Éxitosamente!";
    }
}
