package com.tm.s2.chat.service;

import com.tm.s2.chat.domain.Chat;
import com.tm.s2.chat.domain.ChatCsvs;
import com.tm.s2.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public void importCsvChat(MultipartFile file) {
        ChatCsvs chatCsvs = new ChatCsvs(file);
        chatRepository.saveAll(chatCsvs.getChats());
    }
}
