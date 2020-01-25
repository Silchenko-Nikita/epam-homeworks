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

    // 1 part is non-negative, 2 is negative
    static int[][] splitArray(int[] array) {
        int[][] partArrays = new int[2][array.length];

        int negCount = 0, posCount = 0;
        for (int el : array){
            if (el >= 0) {
                partArrays[0][posCount++] = el;
            } else {
                partArrays[1][negCount++] = el;
            }
        }

        partArrays[0] = Arrays.copyOf(partArrays[0], posCount);
        partArrays[1] = Arrays.copyOf(partArrays[1], negCount);

        return partArrays;
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

        int[][] arrs = splitArray(arr);
        System.out.println("Non-negative elements: " + Arrays.toString(arrs[0]));
        System.out.println("Negative elements: " + Arrays.toString(arrs[1]));
    }
}
