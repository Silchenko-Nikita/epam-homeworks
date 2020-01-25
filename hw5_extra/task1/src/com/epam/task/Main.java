package com.epam.task;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] generateArray(int dim, int lowBound, int highBound) {
        if (dim < 0) return null;

        int [] arr = new int[dim];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (highBound - lowBound)) + lowBound;
        }
        return arr;
    }

    static double getAverageVal(int[] array) {
        int sum = 0;
        for (int el : array){
            sum += el;
        }

        return sum /(1.0 * array.length);
    }

    static int countElementsGreaterThen(int[] array, double val) {
        int count = 0;
        for (int el : array){
            if (el > val) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension -> ");
        int dim = scanner.nextInt();
        if (dim <= 0) {
            System.out.println("Dimension must be positive");
            return;
        }

        int[] arr = generateArray(dim, -50, 50);
        System.out.println("Generated array: " + Arrays.toString(arr));
        double avr = getAverageVal(arr);
        System.out.println("Average value of the array: " + avr);
        System.out.println("Number of elements in the array greater then average value: "
                + countElementsGreaterThen(arr, avr));
    }
}
