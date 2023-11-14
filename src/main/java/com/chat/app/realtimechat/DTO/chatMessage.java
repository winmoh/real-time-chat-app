package com.chat.app.realtimechat.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class chatMessage {
    private String content;
    private String sender;
    private messageType type;
}
