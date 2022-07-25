package com.tm.s2.chat.repository;

import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tm.s2.chat.domain.MessageCount;
import com.tm.s2.chat.domain.UserMessageCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.tm.s2.chat.domain.QChat.chat;

@RequiredArgsConstructor
@Repository
public class ChatCustomRepositoryImpl implements ChatCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MessageCount> findMessageCountGroupByMessageDate() {
        return jpaQueryFactory.select(
                        Projections.fields(MessageCount.class,
                                getFormattedDate().as("messageDate"),
                                chat.message.count().as("count")
                        )).from(chat)
                .groupBy(getFormattedDate())
                .orderBy(getFormattedDate().asc())
                .fetch();
    }

    @Override
    public List<UserMessageCount> findUserMessageCountGroupByUserAndMessageDate() {
        return jpaQueryFactory.select(
                Projections.fields(UserMessageCount.class,
                        chat.userName,
                        getFormattedDate().as("messageDate"),
                        chat.message.count().as("count")
                )).from(chat)
                .groupBy(chat.userName, getFormattedDate())
                .fetch();
    }

    private StringTemplate getFormattedDate() {
        return Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , chat.messageDate
                , ConstantImpl.create("%Y-%m-%d"));
    }

}
