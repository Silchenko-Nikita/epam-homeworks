package com.epam.task;

public class Main {
    static final int LEG_SIZE = 5;

    public static void main(String[] args) {
        // 1
	    int i = 0;
	    while (i < LEG_SIZE) {
	        int j = 0;
	        while (j < i) {
                System.out.print('*');
                j++;
            }
            System.out.println();
            i++;
        }

        i = 0;
        while (i < LEG_SIZE) {
            int j = LEG_SIZE;
            while (i < j) {
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }

        System.out.println();

        // 2
        i = 0;
        while (i < LEG_SIZE) {
            int j = 0;
            while (j < i) {
                System.out.print(' ');
                j++;
            }

            while (j < LEG_SIZE) {
                System.out.print('*');
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println();

        // 3
        i = 0;
        while (i < LEG_SIZE) {
            int j = LEG_SIZE - 1;
            while (j > i) {
                System.out.print(' ');
                j--;
            }

            while (j >= 0) {
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }

        System.out.println();

        // 4
        i = 0;
        while (i < LEG_SIZE) {
            int j = LEG_SIZE - 1;
            while (j > i) {
                System.out.print(' ');
                j--;
            }

            while (j >= 0) {
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }

        i = 0;
        while (i < LEG_SIZE) {
            int j = 0;
            while (j < i) {
                System.out.print(' ');
                j++;
            }

            while (j < LEG_SIZE) {
                System.out.print('*');
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println();

        // 5
        i = 0;
        while (i < LEG_SIZE) {
            int j = LEG_SIZE - 1;
            while (j > i) {
                System.out.print(' ');
                j--;
            }

            while (j >= -i) {
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }

        i = 0;
        while (i < LEG_SIZE) {
            int j = LEG_SIZE - 1;
            while (j > i) {
                System.out.print(' ');
                j--;
            }

            while (j >= -i) {
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }
    }
}
