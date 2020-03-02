import exceptions.BooksNumberException;
import exceptions.InvalidPercentException;
import exceptions.ShellSizeException;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Books books = null;

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

        try {
            books.generateBooks(shellSize * 7 / 10);
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


    private static boolean askIfToSerializeBooks() {
        System.out.print("Do you want to serialize books (y/n) -> ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }


    public static void main(String[] args) {
        generateBooks();

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
    }
}
