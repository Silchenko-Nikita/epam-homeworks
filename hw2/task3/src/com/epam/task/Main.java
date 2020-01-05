package com.epam.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter deposit -> ");
        double deposit = Double.parseDouble(scanner.next());

        System.out.print("Enter number of months -> ");
        double months = Double.parseDouble(scanner.next());

        System.out.print("Enter annual percentage -> ");
        double percentage = Double.parseDouble(scanner.next());

        double income = deposit * (months / 12) * (percentage / 100);

        System.out.printf("Income: %.2f\n", income);
    }
}
