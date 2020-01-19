package com.epam.task;

import java.util.Scanner;

public class Main {
    static void printPyramid(int height) {
        if (height < 1 || height > 9) {
            System.out.println("Wrong height");
            return;
        }

        int i = 1;
        while (i <= height) {
            int j = 1;
            while (j < 2 * height) {
                int abs = Math.abs(j - height);
                System.out.print((abs >= i) ? " " : (i - abs));
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter height -> ");
        int height = scanner.nextInt();
        printPyramid(height);
    }
}
