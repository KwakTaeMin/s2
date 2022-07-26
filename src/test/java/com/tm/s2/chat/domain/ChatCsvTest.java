package com.tm.s2.chat.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatCsvTest {

    @Test
    public void createChatCsv() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        ChatCsv chatCsv = new ChatCsv("username", "message", nowDateTime);
        assertThat(chatCsv).isNotNull();
    }

    @Test
    public void toChat() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        ChatCsv chatCsv = new ChatCsv("username", "message", nowDateTime);
        Chat chat = chatCsv.toChat();
        assertThat(chat.getUserName()).isEqualTo("username");
        assertThat(chat.getMessage()).isEqualTo("message");
        assertThat(chat.getMessageDate()).isEqualTo(nowDateTime);
    }
}
