package com.tm.s2.chat.service;

import com.tm.s2.chat.domain.*;
import com.tm.s2.chat.domain.MessageCount;
import com.tm.s2.chat.repository.ChatCustomRepository;
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
	private final ChatCustomRepository chatCustomRepository;

	public List<Chat> getChats() {
		return chatRepository.findAll();
	}

	public void importCsvChat(MultipartFile file) {
		ChatCsvList chatCsvList = new ChatCsvList(file);
		Chats chats = chatCsvList.getChats();
		chatRepository.saveAll(chats.getChats());
	}

	public List<FavoriteWord> favoriteWords() {
		List<String> messages = chatRepository.findAll()
				.stream()
			.map(Chat::getMessage)
			.collect(Collectors.toList());

		FavoriteWords favoriteWords = new FavoriteWords(messages);
		return favoriteWords.getFavoriteWords();
	}

	public List<FavoriteWord> favoriteWordsByUserName(String userName) {
		List<String> messages = chatRepository.findByUserName(userName)
				.stream()
				.map(Chat::getMessage)
				.collect(Collectors.toList());

		FavoriteWords favoriteWords = new FavoriteWords(messages);
		return favoriteWords.getFavoriteWords();
	}

	public List<MessageCount> getMessageCountGroupByMessageDate() {
		return chatCustomRepository.findMessageCountGroupByMessageDate();
	}

	public List<UserMessageCount> getMessageCountGroupByUserNameAndMessageDate() {
		return chatCustomRepository.findUserMessageCountGroupByUserAndMessageDate();
	}

	public long getAllMessageCount() {
		return chatRepository.findAll().size();
	}

	public long getAllWordCount() {
		return chatRepository.findAll().stream()
				.map(chat ->chat.getMessage().split(" "))
				.collect(Collectors.toList())
				.stream().flatMap(Arrays::stream)
				.count();
//				.collect(Collectors.toList())
//				.size();
	}

	public long getMessageCountByUserName(String userName) {
		return chatRepository.findByUserName(userName).size();
	}

	public List<UserMessageCount> getUserMessageCountByDate() {
		return chatCustomRepository.findUserMessageCountGroupByUserAndMessageDate();
	}
}
