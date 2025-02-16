package com.example.chat.controller;

import com.example.chat.Entities.ChatMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
    {
        return chatMessage;
    }

    public ChatMessage addUser(@Playload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAcessor) 
    {   
        // Adiciona o username na sessão do websocket
        headerAcessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
