package com.tm.s2.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FavoriteWord implements Comparable<FavoriteWord>{

	private String word;
	private int count;

	@Override
	public int compareTo(FavoriteWord favoriteWord) {

		if(this.count > favoriteWord.count)
			return 1;
		else if(this.count == favoriteWord.count)
			return 0;
		else
			return -1;
	}

}
