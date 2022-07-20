package com.tm.s2.chat.service;

import com.tm.s2.chat.domain.*;
import com.tm.s2.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatService {

	private final ChatRepository chatRepository;

	public List<Chat> getChats() {
		return chatRepository.findAll();
	}

	public void importCsvChat(MultipartFile file) {
		ChatCsvList chatCsvList = new ChatCsvList(file);
		Chats chats = chatCsvList.getChats();
		chatRepository.saveAll(chats.getChats());
	}

	public List<FavoriteWord> favoriteWords() {
		List<String> messages = chatRepository.findAll().stream()
			.map(Chat::getMessage)
			.collect(Collectors.toList());

		FavoriteWords favoriteWords = new FavoriteWords(messages);
		return favoriteWords.getFavoriteWords();
	}
}
