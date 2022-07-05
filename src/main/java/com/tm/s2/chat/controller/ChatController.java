package com.tm.s2.chat.controller;

import com.tm.s2.chat.domain.Chat;
import com.tm.s2.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public List<Chat> getChat() {
        return chatService.getChats();
    }

    @PostMapping("/import/csv")
    public void importCsvChat(@RequestParam("file") MultipartFile file) {
        chatService.importCsvChat(file);
    }
}
