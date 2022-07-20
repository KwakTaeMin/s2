package com.tm.s2.chat.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime messageDate;

    public Chat(String userName, String message, LocalDateTime messageDate) {
        this.userName = userName;
        this.message = message;
        this.messageDate = messageDate;
    }
}
