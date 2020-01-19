package com.epam.task;

import java.util.Scanner;

public class Main {

    // index starts from 1
    static char getFirstCharOfNWord(String str, int wordIndex) {
        int i = 0, currWordInd = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if ((i == 0 || str.charAt(i - 1) == ' ') && ch != ' '){
                currWordInd++;
            }

            if (wordIndex == currWordInd) {
                return ch;
            }

            i++;
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string -> ");
        String inputStr = scanner.nextLine();

        System.out.print("Enter word number -> ");
        int wordNumber = scanner.nextInt();

        char firstCharOfNWord = getFirstCharOfNWord(inputStr, wordNumber);
        System.out.println("First character of " + wordNumber + "'s word: " +firstCharOfNWord);
    }
}
