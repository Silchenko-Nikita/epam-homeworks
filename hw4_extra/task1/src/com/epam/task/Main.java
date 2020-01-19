package com.epam.task;

import java.util.Scanner;

public class Main {
    // the first way
    static String getReversedLastTwoDigits(int number){
        int lastTwoDigits = number % 100;
        return Integer.toString(lastTwoDigits % 10)+ (number > 10 ? Integer.toString(lastTwoDigits / 10) : "");
    }

    // the second way
    static String getReversedLastTwoDigits2(int number){
        String strRepr = Integer.toString(number);
        int strLength = strRepr.length();
        return strRepr.length() > 1 ? ("" + strRepr.charAt(strLength - 1)  + strRepr.charAt(strLength - 2)) :
                ("" + strRepr.charAt(strLength - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number -> ");
        int number = scanner.nextInt();
        String res = getReversedLastTwoDigits(number);
        System.out.println("Result: " + res);
    }
}
