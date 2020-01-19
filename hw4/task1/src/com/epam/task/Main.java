package com.epam.task;

import java.util.Scanner;

public class Main {
    // the first way
    static String getUniqueChars(String str) {
        StringBuilder res = new StringBuilder();

        while (str.length() > 0) {
            char ch = str.charAt(0);
            res.append(ch);
            str = str.replaceAll(Character.toString(ch), "");
        }

        return res.toString();
    }

    // the second way
    static String getUniqueChars2(String str) {
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);

            if (!res.toString().contains(Character.toString(ch))) {
                res.append(ch);
            }

            i++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string -> ");
        String input = scanner.nextLine();
        String res = getUniqueChars(input);
        System.out.println("Unique chars: " + res);
    }
}
