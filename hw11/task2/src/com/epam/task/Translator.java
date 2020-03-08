package com.epam.task;

import java.util.HashMap;

public class Translator {
    private HashMap<String, String> dict = new HashMap<>();

    public void addWord(String word, String translatedWord) {
        dict.put(word, translatedWord);
    }

    public String translate(String phrase) {
        String[] words = phrase.split(" ");
        StringBuilder translated = new StringBuilder();
        for(String word: words) {
            String translatedWord = dict.getOrDefault(word, word);
            translated.append(translatedWord).append(" ");
        }
        return translated.toString().stripTrailing();
    }
}
