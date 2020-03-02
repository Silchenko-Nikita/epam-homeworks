package com.epam.task;

import com.epam.task.exceptions.BooksNumberException;
import com.epam.task.exceptions.InvalidPercentException;
import com.epam.task.exceptions.ShellSizeException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Books books = null;
    static BooksSerializer booksSerializer = new BooksSerializer();

    private static void generateBooks() {
        System.out.print("Enter books shell size " +
                "(it will be generated 7/10 of this number books + added one specific) -> ");
        int shellSize = scanner.nextInt();
        scanner.nextLine();
        try {
            books = new Books(shellSize);
        } catch (ShellSizeException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        books.generateBooks(shellSize * 7 / 10);
        try {
            books.add(new Book(5001, "Harry Potter", "Joanne Rowling","Foo too",
                    1998, 550, 200));
        } catch (BooksNumberException e) {
            // nothing
        }
        System.out.println();
    }
    
    private static void repriceBooks() {
        System.out.print("Enter percent to reprice (from -100) -> ");
        double percent = scanner.nextDouble();
        scanner.nextLine();

        try {
            books.repriceBooks(percent);
        } catch (InvalidPercentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    private static String getAuthor() {
        System.out.print("Enter author whose books to view -> ");
        String author = scanner.nextLine();
        if (author.isBlank()) {
            System.out.println("Author must be specified");
            System.exit(0);
        }

        System.out.println();
        return author;
    }

    private static Books getAuthorsBooks(String author) {
        Books authorsBooks = null;

        try {
            authorsBooks = books.getAuthorsBooks(author);
        } catch (BooksNumberException | ShellSizeException e) {
            System.out.println(e.getMessage());
        }
        return authorsBooks;
    }

    private static int getYear() {
        System.out.print("Enter year published after which books to show -> ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return year;
    }

    private static Books getPublishedAfterYearBooks(int year) {
        Books booksPublishedAfterYear = null;
        try {
            booksPublishedAfterYear = books.getBooksPublishedAfter(year);
        } catch (BooksNumberException | ShellSizeException e) {
            System.out.println(e.getMessage());
        }
        return booksPublishedAfterYear;
    }

    private static void printBooksWithMessage(String message, Books books) {
        System.out.println(message);
        System.out.println(books);
        System.out.println();
    }

    private static boolean askIfToDeserializeBooks() {
        System.out.print("Do you want to deserialize books (y/n) -> ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }

    private static void deserializeBooks() {
        System.out.print("Enter file name from which to deserialize books -> ");
        String filename = scanner.nextLine();
        try {
            books = booksSerializer.deserializeBooks(filename);
        } catch (FileNotFoundException e) {
            System.out.println("No such file: " + filename);
        }

        if (books == null) {
            System.exit(0);
        }
    }

    private static boolean askIfToSerializeBooks() {
        System.out.print("Do you want to serialize books (y/n) -> ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }

    private static void serializeBooks() {
        System.out.print("Enter file name in which to serialize books -> ");
        String filename = scanner.nextLine();
        booksSerializer.serializeBooks(books, filename);
    }

    public static void main(String[] args) {
        boolean toDeserializeBooks = askIfToDeserializeBooks();

        if (toDeserializeBooks) {
            deserializeBooks();
        } else {
            generateBooks();
        }

        printBooksWithMessage("Basic books:", books);
        printBooksWithMessage("Books sorted by author names:", books.getSortedByAuthorsBooks());
        printBooksWithMessage("Books sorted by publisher names:", books.getSortedByPublishersBooks());
        printBooksWithMessage("Books sorted by prices in descending order:", books.getSortedByPricesDescBooks());

        repriceBooks();

        printBooksWithMessage("Repriced books:", books);

        String author = getAuthor();
        Books authorsBooks = getAuthorsBooks(author);

        printBooksWithMessage(author + "'s books:", authorsBooks);

        int year = getYear();
        Books booksPublishedAfterYear = getPublishedAfterYearBooks(year);

        printBooksWithMessage("Books published after " + year + ":", booksPublishedAfterYear);

        boolean toSerializeBooks = askIfToSerializeBooks();

        if (toSerializeBooks) {
            serializeBooks();
        }
    }
}
