package com.epam.hello;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter symbol -> ");
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.next().charAt(0);
        System.out.println("*  *  ****  *     *       **".replace('*', symbol));
        System.out.println("*  *  *     *     *      *  *".replace('*', symbol));
        System.out.println("****  ****  *     *     *    *".replace('*', symbol));
        System.out.println("*  *  *     *  *  *  *   *  *".replace('*', symbol));
        System.out.println("*  *  ****  ****  ****    **".replace('*', symbol));
    }
}
