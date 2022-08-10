package com.tm.s2.chat.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FavoriteWordsTest {

    @Test
    public void create() {
        FavoriteWords favoriteWords = new FavoriteWords(Arrays.asList("one", "one", "two"));
        assertThat(favoriteWords.getFavoriteWords()).isNotNull();
        assertThat(favoriteWords.getFavoriteWords().size()).isEqualTo(2);
    }
}
