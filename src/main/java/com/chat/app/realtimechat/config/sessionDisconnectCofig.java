package com.chat.app.realtimechat.config;


import com.chat.app.realtimechat.DTO.chatMessage;
import com.chat.app.realtimechat.DTO.messageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@AllArgsConstructor
@Slf4j
public class sessionDisconnectCofig {
    private final SimpMessageSendingOperations messageTemplate;


    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event){
        StompHeaderAccessor headers=StompHeaderAccessor.wrap(event.getMessage());
        String username=(String) headers.getSessionAttributes().get("username");
        if(username!=null){
            log.info("User disconnected {}",username);
            chatMessage message= chatMessage.builder()
                    .type(messageType.LEAVE)
                    .sender(username)
                    .build();
            messageTemplate.convertAndSend("/topic/public",message);

        }


    }
}
