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

public class ChatCsvList {

    private final String EXCEPTION_MESSAGE = "Chat CSV 파일 Import 시 실패하였습니다.";

    private List<ChatCsv> chatCsvList;

    public ChatCsvList(MultipartFile file) {
        this.importChatCsvList(file);
    }

    public List<Chat> getChats() {
        return chatCsvList.stream()
                .map(ChatCsv::toChat)
                .collect(Collectors.toList());
    }

    private void importChatCsvList(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<ChatCsv> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ChatCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            this.chatCsvList = csvToBean.parse();

        } catch (Exception exception) {
            throw new ChatCsvImportException(EXCEPTION_MESSAGE);
        }

    }


}
