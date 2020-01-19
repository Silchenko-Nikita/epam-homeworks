package com.epam.task;

import java.util.Scanner;

public class Main {
    
    static String getBinaryRepr(int number) {

        StringBuilder repr = new StringBuilder();
        do {
            repr.insert(0, number % 2 == 1 ? "1" : "0");
            number >>= 1;
        } while (number > 0);

        return repr.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number -> ");
        int number = scanner.nextInt();
        String res = getBinaryRepr(number);
        System.out.println("Result: " + res);
    }


}
