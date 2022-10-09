package com.reto.service.impl;

import com.reto.model.Client;
import com.reto.model.Message;
import com.reto.repository.MessageRepository;
import com.reto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Message postMessage(Message message) {

        if(message.getIdMessage() == null){
            messageRepository.save(message);
        }else{
            Optional<Message> messageOptional = messageRepository.findById(message.getIdMessage());
            if(messageOptional.isEmpty()){
                message = messageRepository.save(message);
            }else{
                message = messageOptional.get();
            }
        }
        return message;
    }
}
