package com.epam.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number -> ");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.next());
        int reverseNumber = number / 100 + (number % 100 / 10) * 10 + number % 10 * 100;
        System.out.println("Reverse number: " + reverseNumber);
        int diff = number - reverseNumber;
        System.out.println("Difference between numbers: " + diff);
    }
}
