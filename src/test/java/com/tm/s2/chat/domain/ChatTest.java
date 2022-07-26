package com.tm.s2.chat.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatTest {

    @Test
    public void createChat() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        Chat chat = new Chat("username", "message", nowDateTime);

        assertThat(chat.getUserName()).isEqualTo("username");
        assertThat(chat.getMessage()).isEqualTo("message");
        assertThat(chat.getMessageDate()).isEqualTo(nowDateTime);
    }
}
