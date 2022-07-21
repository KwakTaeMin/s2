package com.tm.s2.chat.repository;

import com.tm.s2.chat.domain.MessageCount;
import com.tm.s2.chat.domain.UserMessageCount;

import java.util.List;

public interface ChatCustomRepository {

    List<MessageCount> findMessageCountGroupByMessageDate();
    List<UserMessageCount> findUserMessageCountGroupByUserAndMessageDate();
}
