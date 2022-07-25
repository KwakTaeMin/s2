package com.tm.s2.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MessageCount {

    private String messageDate;
    private long count;

    public MessageCount(String messageDate, long count) {
        this.messageDate = messageDate;
        this.count = count;
    }
}
