package com.chat.app.realtimechat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class webSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry reg){
        reg.addEndpoint("/ws").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry reg){
        reg.setApplicationDestinationPrefixes("/app");
        reg.enableSimpleBroker("topic");
    }
}
