package com.epam.task;

import java.util.Scanner;

public class TranslatorHolder {
    private Translator translator;

    public TranslatorHolder(Translator translator) {
        this.translator = translator;

        translator.addWord("Hello", "Привет");
        translator.addWord("world", "мир");
        translator.addWord("I", "Я");
        translator.addWord("am", "");
        translator.addWord("tester", "тестеровщик");
    }

    public void askForPhraseAndTranslate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phrase: ");
        String phrase = scanner.nextLine();

        System.out.print("Перевод фразы на русский: ");
        System.out.println(translator.translate(phrase));
    }
}
