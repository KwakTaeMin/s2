package com.tm.s2.chat.domain;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class MessageCount {

    private LocalDate messageDate;
    private long count;

    public MessageCount(LocalDate messageDate, long count) {
        this.messageDate = messageDate;
        this.count = count;
    }
}
