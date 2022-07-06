package com.tm.s2.chat.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Date messageDate;

    public Chat(String userName, String message, Date messageDate) {
        this.userName = userName;
        this.message = message;
        this.messageDate = messageDate;
    }
}
