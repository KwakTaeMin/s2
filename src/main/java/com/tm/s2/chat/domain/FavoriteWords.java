package com.tm.s2.chat.domain;

import java.util.*;
import java.util.stream.Collectors;

public class FavoriteWords {

    private List<FavoriteWord> favoriteWords;

    public FavoriteWords(List<String> messages) {
        this.favoriteWords = initFavoriteWords(messages);
    }

    public List<FavoriteWord> getFavoriteWords() {
        return Collections.unmodifiableList(this.favoriteWords);
    }

    private List<FavoriteWord> initFavoriteWords(List<String> messages) {
        List<String> words = splitMessageToWords(messages);
        List<FavoriteWord> favoriteWords = countWords(words);
        return favoriteWords.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private List<String> splitMessageToWords(List<String> messages) {
        return messages.stream()
                .map((message) -> message.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    private List<FavoriteWord> countWords(List<String> words) {
        List<FavoriteWord> favoriteWords = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>(words); //distinct
        wordsSet.forEach(word -> favoriteWords.add(new FavoriteWord(word, Collections.frequency(words, word))));
        return favoriteWords;
    }



}
