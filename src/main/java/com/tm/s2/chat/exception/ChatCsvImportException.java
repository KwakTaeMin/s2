package com.tm.s2.chat.exception;

public class ChatCsvImportException extends RuntimeException {

    private final String EXCEPTION_MESSAGE = "Chat CSV 파일 Import 시 실패하였습니다.";

    public ChatCsvImportException() {
        //super(EXCEPTION_MESSAGE);
    }

    public ChatCsvImportException(String message) {
        super(message);
    }
}
