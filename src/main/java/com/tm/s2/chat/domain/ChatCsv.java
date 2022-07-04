package com.tm.s2.chat.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ChatCsv {

    @CsvBindByName
    private String userName;
    @CsvBindByName
    private String message;
    @CsvBindByName
    private Date messageDate;

    public Chat toChat() {
        return new Chat(this.userName, this.message, this.messageDate);
    }

}
