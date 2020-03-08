package com.epam.task;

public class Main {

    public static void main(String[] args) {
        TranslatorHolder translatorHolder = new TranslatorHolder(new Translator());
        translatorHolder.askForPhraseAndTranslate();
    }
}
