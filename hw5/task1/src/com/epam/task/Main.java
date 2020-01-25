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

    static int[] sumArrayElements(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return null;

        int [] arr = new int[arr1.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i] + arr2[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter arrays dimension -> ");
        int dim = scanner.nextInt();
        if (dim <= 0) {
            System.out.println("Dimension must be positive");
            return;
        }

        int[] arr1 = generateArray(dim, -50, 50);
        int[] arr2 = generateArray(dim, -50, 50);
        System.out.println("First array: " + Arrays.toString(arr1));
        System.out.println("Second array: " + Arrays.toString(arr2));
        System.out.println("Sum array: " + Arrays.toString(sumArrayElements(arr1, arr2)));
    }
}
