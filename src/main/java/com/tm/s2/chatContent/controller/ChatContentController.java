package com.tm.s2.chatContent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatContentController {

    @GetMapping
    public String getChat() {
        return "chat";
    }
}
