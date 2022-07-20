package com.tm.s2.chat.domain;

import java.util.Collections;
import java.util.List;

public class Chats {

	private List<Chat> chats;

	public Chats(List<Chat> chats) {
		this.chats = chats;
	}

	public List<Chat> getChats() {
		return Collections.unmodifiableList(this.chats);
	}
}
