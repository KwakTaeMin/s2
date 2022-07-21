package com.tm.s2.chat.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserMessageCount extends MessageCount {
    private String username;

    public UserMessageCount(LocalDate messageDate, long count, String username) {
        super(messageDate, count);
        this.username = username;
    }
}
