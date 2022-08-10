package com.tm.s2.chat.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FavoriteWordTest {

    @Test
    public void create() {
        FavoriteWord favoriteWord = new FavoriteWord("word", 10);
        assertThat(favoriteWord.getWord()).isEqualTo("word");
        assertThat(favoriteWord.getCount()).isEqualTo(10);
    }

    @Test void compareTo() {
        FavoriteWord favoriteWord = new FavoriteWord("word", 10);
        FavoriteWord favoriteWord2 = new FavoriteWord("word2", 11);
        assertThat(favoriteWord.compareTo(favoriteWord2)).isEqualTo(-1);
        assertThat(favoriteWord2.compareTo(favoriteWord)).isEqualTo(1);
    }

}
