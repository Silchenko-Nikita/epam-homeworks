package com.epam.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter books shell size " +
                "(it will be generated 7/10 of this number books + added one specific) -> ");
        int shellSize = scanner.nextInt();
        if (shellSize < 2) {
            System.out.println("Shell size should be more then 2");
            return;
        }

        Books books = new Books(shellSize);
        books.generateBooks(shellSize * 7 / 10);
        books.add(new Book(5001, "Harry Potter", "Joanne Rowling","Foo too",
                1998, 550, 200));

        System.out.println();
        System.out.println("Basic books:");
        books.view();

        System.out.print("Enter percent to reprice (from -100) -> ");
        double percent = scanner.nextDouble();
        if (percent < -100) {
            System.out.println("Percent should be greater then -100");
            return;
        }

        books.repriceBooks(percent);
        System.out.println();
        System.out.println("Repriced books:");
        books.view();

        scanner.nextLine();
        System.out.print("Enter author whose books to view -> ");
        String author = scanner.nextLine();
        if (author.isBlank()) {
            System.out.println("Author must be specified");
            return;
        }

        System.out.println();
        System.out.println(author + "'s books:");
        Books authorsBooks = books.getAuthorsBooks(author);
        authorsBooks.view();

        System.out.print("Enter year published after which books to show -> ");
        int year = scanner.nextInt();
        Books booksPublishedAfterYear = books.getBooksPublishedAfter(year);

        System.out.println();
        System.out.println("Books published after " + year + ":");
        booksPublishedAfterYear.view();
    }
}
