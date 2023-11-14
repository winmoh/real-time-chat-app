package com.chat.app.realtimechat.chat;


import com.chat.app.realtimechat.DTO.chatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class chatController {



    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public chatMessage sendMessage (@Payload chatMessage CMess){
        return CMess;

    }


    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public chatMessage addUser(@Payload chatMessage CMess, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username",CMess.getSender());
        return CMess;


    }
}
