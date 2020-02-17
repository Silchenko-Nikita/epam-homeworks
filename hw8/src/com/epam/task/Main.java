package com.epam.task;

import com.epam.task.exceptions.BooksNumberException;
import com.epam.task.exceptions.InvalidPercentException;
import com.epam.task.exceptions.ShellSizeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter books shell size " +
                "(it will be generated 7/10 of this number books + added one specific) -> ");
        int shellSize = scanner.nextInt();
        Books books;
        try {
            books = new Books(shellSize);
        } catch (ShellSizeException e) {
            System.out.println(e.getMessage());
            return;
        }

        books.generateBooks(shellSize * 7 / 10);
        try {
            books.add(new Book(5001, "Harry Potter", "Joanne Rowling","Foo too",
                    1998, 550, 200));
        } catch (BooksNumberException e) {
            // nothing
        }

        System.out.println();
        System.out.println("Basic books:");
        System.out.println(books);

        System.out.println();
        System.out.println("Books sorted by authors names:");
        try {
            System.out.println(books.getSortedByAuthorsBooks());
        } catch (ShellSizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Books sorted by publishers names:");
        try {
            System.out.println(books.getSortedByPublishersBooks());
        } catch (ShellSizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Books sorted by prices in descending order:");
        try {
            System.out.println(books.getSortedByPricesDescBooks());
        } catch (ShellSizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter percent to reprice (from -100) -> ");
        double percent = scanner.nextDouble();

        try {
            books.repriceBooks(percent);
        } catch (InvalidPercentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Repriced books:");
        System.out.println(books);

        scanner.nextLine();
        System.out.print("Enter author whose books to view -> ");
        String author = scanner.nextLine();
        if (author.isBlank()) {
            System.out.println("Author must be specified");
            return;
        }

        System.out.println();
        System.out.println(author + "'s books:");
        Books authorsBooks = null;

        try {
            authorsBooks = books.getAuthorsBooks(author);
        } catch (BooksNumberException | ShellSizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(authorsBooks);

        System.out.print("Enter year published after which books to show -> ");
        int year = scanner.nextInt();
        Books booksPublishedAfterYear = null;
        try {
            booksPublishedAfterYear = books.getBooksPublishedAfter(year);
        } catch (BooksNumberException | ShellSizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Books published after " + year + ":");
        System.out.println(booksPublishedAfterYear);
    }
}
