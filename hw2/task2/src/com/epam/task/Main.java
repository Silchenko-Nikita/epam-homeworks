package com.epam.task;

import java.util.Scanner;

public class Main {
    final static double GRAMS_IN_POUND = 453.6;

    public static void main(String[] args) {
        System.out.print("Enter weight in pounds -> ");
        Scanner scanner = new Scanner(System.in);
        double weightPounds = Double.parseDouble(scanner.next());
        double weightGrams = weightPounds * GRAMS_IN_POUND;
        int kilos = ((int) weightGrams) / 1000;
        double grams = weightGrams - kilos * 1000;
        System.out.printf("Weight: %d kilos %.2f grams\n", kilos, grams);
    }
}
