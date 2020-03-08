package com.epam.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list's elements number, left bound, right bound: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");

        int listElsNum = Integer.parseInt(numbers[0]);
        int listLeftBound = Integer.parseInt(numbers[1]);
        int listRightBound = Integer.parseInt(numbers[2]);

        System.out.print("Enter set's elements number, left bound, right bound: ");
        input = scanner.nextLine();
        numbers = input.split(", ");

        int setElsNum = Integer.parseInt(numbers[0]);
        int setLeftBound = Integer.parseInt(numbers[1]);
        int setRightBound = Integer.parseInt(numbers[2]);

        try {
            Collections collections = new Collections(
                    CollectionsGenerator.generateList(listElsNum, listLeftBound, listRightBound),
                    CollectionsGenerator.generateSet(setElsNum, setLeftBound, setRightBound));

            collections.displayList();
            collections.displaSet();
        } catch (InvalidRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
