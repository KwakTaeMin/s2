package com.tm.s2.chatContent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ChatContent {

    @Id
    private long id;
    private String userName;
    private String message;
    private Date messageDate;

    protected ChatContent() {}

}
