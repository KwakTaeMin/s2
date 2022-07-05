package com.tm.s2.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.s2.chat.domain.Chat;
import com.tm.s2.chat.domain.ChatCsvList;
import com.tm.s2.chat.repository.ChatRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public void importCsvChat(MultipartFile file) {
        ChatCsvList chatCsvList = new ChatCsvList(file);
        chatRepository.saveAll(chatCsvList.getChats());
    }
}
