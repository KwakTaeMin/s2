package com.tm.s2.chat.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ChatCsv {

    @CsvBindByName
    private String userName;
    @CsvBindByName
    private String message;
    @CsvBindByName
    private LocalDateTime messageDate;

    public Chat toChat() {
        return new Chat(this.userName, this.message, this.messageDate);
    }

}
