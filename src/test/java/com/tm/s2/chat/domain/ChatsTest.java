package com.tm.s2.chat.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatsTest {

    @Test
    public void createChats() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        Chat chat = new Chat("username", "message", nowDateTime);
        Chat chat2 = new Chat("username2", "message2", nowDateTime);
        List<Chat> chatList = Arrays.asList(chat, chat2);
        Chats chats = new Chats(chatList);

        assertThat(chats.getChats()).isNotNull();
        assertThat(chats.getChats().size()).isEqualTo(2);

    }
}
