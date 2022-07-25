package com.tm.s2.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserMessageCount extends MessageCount {
    private String userName;

    public UserMessageCount(String messageDate, long count, String userName) {
        super(messageDate, count);
        this.userName = userName;
    }
}
