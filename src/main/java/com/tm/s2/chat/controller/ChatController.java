package com.tm.s2.chat.controller;

import com.tm.s2.chat.domain.Chat;
import com.tm.s2.chat.domain.FavoriteWord;
import com.tm.s2.chat.domain.MessageCount;
import com.tm.s2.chat.domain.UserMessageCount;
import com.tm.s2.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<List<Chat>> getChat() {
        return ResponseEntity.ok(chatService.getChats());
    }

    @GetMapping("/word/favorite")
    public ResponseEntity<List<FavoriteWord>> getFavorite() {
        return ResponseEntity.ok(chatService.favoriteWords());
    }

    @GetMapping("/word/favorite/{userName}")
    public ResponseEntity<List<FavoriteWord>> getFavoriteByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(chatService.favoriteWordsByUserName(userName));
    }

    @GetMapping("/word/count")
    public ResponseEntity<Long> getWordCount() {
        return ResponseEntity.ok(chatService.getAllWordCount());
    }

    @GetMapping("/message/count")
    public ResponseEntity<Long> getMessageCount() {
        return ResponseEntity.ok(chatService.getAllMessageCount());
    }

    @GetMapping("/message/count/{userName}")
    public ResponseEntity<Long> getMessageCountByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(chatService.getMessageCountByUserName(userName));
    }

    @GetMapping("/message/count/group/date")
    public ResponseEntity<List<MessageCount>> getMessageCountGroupDate() {
        return ResponseEntity.ok(chatService.getMessageCountGroupByMessageDate());
    }

    @GetMapping("/message/count/group/user-date")
    public ResponseEntity<List<UserMessageCount>> getMessageCountGroupUserNameAndDate() {
        return ResponseEntity.ok(chatService.getMessageCountGroupByUserNameAndMessageDate());
    }

    @PostMapping("/import/csv")
    public void importCsvChat(@RequestParam("file") MultipartFile file) {
        chatService.importCsvChat(file);
    }
}
