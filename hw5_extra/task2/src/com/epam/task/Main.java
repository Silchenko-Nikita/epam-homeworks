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

    static int[] concatArrays(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, res, 0, arr1.length);
        System.arraycopy(arr2, 0, res, arr1.length, arr2.length);

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first array dimension -> ");
        int dim1 = scanner.nextInt();
        System.out.print("Enter second array dimension -> ");
        int dim2 = scanner.nextInt();

        if (dim1 <= 0 || dim2 <= 0) {
            System.out.println("Dimension must be positive");
            return;
        }

        int[] arr1 = generateArray(dim1, -50, 50);
        int[] arr2 = generateArray(dim2, -50, 50);
        System.out.println("Generated arrays: " + Arrays.toString(arr1) + ", " + Arrays.toString(arr2));
        System.out.println("Arrays concatenation: " + Arrays.toString(concatArrays(arr1, arr2)));
    }
}
