package com.tm.s2.chat.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.s2.chat.domain.Chat;
import com.tm.s2.chat.domain.ChatCsvList;
import com.tm.s2.chat.repository.ChatRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatService {

	private final ChatRepository chatRepository;

	public List<Chat> getChats() {
		// todo : to change functions findAll(Sort sort)
		return chatRepository.findAll();

	}

	public void importCsvChat(MultipartFile file) {
		ChatCsvList chatCsvList = new ChatCsvList(file);
		chatRepository.saveAll(chatCsvList.getChats());
	}

	public HashMap<String, Integer> favoriteWords() {
		List<String> messages = chatRepository.findAll().stream()
			.map(Chat::getMessage)
			.collect(Collectors.toList());

		List<String> words = messages.stream()
			.map((message) -> message.split(" "))
			.flatMap(Arrays::stream)
			.collect(Collectors.toList());

		Set<String> wordsSet = new HashSet<>(words); //distinct
		HashMap<String, Integer> favoriteWords = new HashMap<>();

		wordsSet.stream()
			.forEach(word -> favoriteWords.put(word, Collections.frequency(words, word)));

		return favoriteWords;
	}
}
