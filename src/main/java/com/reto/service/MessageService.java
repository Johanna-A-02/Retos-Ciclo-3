package com.reto.service;

import com.reto.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessage();

    String postMessage(Message message);
}
