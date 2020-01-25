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

    static int[] getArrayWithRemovedDuplicates(int[] arr, int[] values) {
        int[] counts = new int[values.length];
        int[] arrRemovedVals = new int[arr.length];

        int resArrInd = 0;
        for (int value : arr) {
            boolean valueToRemove = false;
            for (int j = 0; j < values.length; j++) {
                if (value == values[j]) {
                    counts[j]++;

                    if (counts[j] > 1) {
                        valueToRemove = true;
                    }
                }
            }

            if (!valueToRemove) {
                arrRemovedVals[resArrInd++] = value;
            }
        }

        arr = Arrays.copyOf(arrRemovedVals, resArrInd);
        return arr;
    }

    static int[] getMinMax(int[] arr) {
        int min = arr[0], max = arr[0];

        for (int value : arr) {
            if (min > value) {
                min = value;
            }

            if (max < value) {
                max = value;
            }
        }

        return new int[]{min, max};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimension -> ");
        int dim = scanner.nextInt();
        if (dim <= 0) {
            System.out.println("Dimension must be positive");
            return;
        }

        int[] arr = generateArray(dim, -5, 5);
        System.out.println("Generated array: " + Arrays.toString(arr));

        int[] minMax = getMinMax(arr);
        arr = getArrayWithRemovedDuplicates(arr, minMax);

        System.out.println("Min array value: " + minMax[0]);
        System.out.println("Max array value: " + minMax[1]);
        System.out.println("Array with removed min and max values duplicates: " + Arrays.toString(arr));
    }
}
