package com.tm.s2.chat.domain;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tm.s2.chat.exception.ChatCsvImportException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class ChatCsvs {

    private List<ChatCsv> chatCsvs;

    public ChatCsvs(MultipartFile file) {
        this.importChatCsvs(file);
    }

    public List<Chat> getChats() {
        return chatCsvs.stream()
                .map(ChatCsv::toChat)
                .collect(Collectors.toList());
    }

    private void importChatCsvs(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<ChatCsv> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ChatCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            this.chatCsvs = csvToBean.parse();

        } catch (Exception exception) {
            throw new ChatCsvImportException();
        }

    }


}
