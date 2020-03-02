package com.epam.task;

import com.epam.task.comparators.BooksAuthorsComparator;
import com.epam.task.comparators.BooksPricesDescComparator;
import com.epam.task.comparators.BooksPublishersComparator;
import com.epam.task.exceptions.BooksNumberException;
import com.epam.task.exceptions.InvalidPercentException;
import com.epam.task.exceptions.ShellSizeException;

import java.io.Serializable;
import java.util.Arrays;

public class Books implements Serializable {
    private Book[] books;
    private int booksNum = 0;
    private Validator validator = new Validator();

    public Books(int shellSize) throws ShellSizeException {
        validator.validateShellSize(shellSize);

        this.books = new Book[shellSize];
    }

    private Books(Book[] books, int booksNum) {
        this.books = books;
        this.booksNum = booksNum;
    }

    @Override
    public String toString() {
        if (booksNum == 0) {
            return "Empty shell\n";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < booksNum; i++) {
            stringBuilder.append("Book №").append(i + 1).append(":\n").append(books[i]).append("\n\n");
        }
        return stringBuilder.toString();
    }

    public void add(Book book) throws BooksNumberException {
        validator.validateBooksNumber(booksNum, books.length);

        books[booksNum++] = book;
    }

    public void repriceBooks(double percent) throws InvalidPercentException {
        validator.validatePercent(percent);

        for (int i = 0; i < booksNum; i++) {
            Book book = books[i];
            double price = book.getPrice();
            book.setPrice(price + price * 0.01 * percent);
        }
    }

    public Books getAuthorsBooks(String author) throws BooksNumberException, ShellSizeException {
        Books authorsBooks = new Books(booksNum);

        for (int i = 0; i < booksNum; i++) {
            Book book = books[i];
            if (book.getAuthor().equals(author)) {
                authorsBooks.add(book);
            }
        }

        return authorsBooks;
    }

    public Books getBooksPublishedAfter(int year) throws BooksNumberException, ShellSizeException {
        Books booksPublishedAfterYear = new Books(booksNum);

        for (int i = 0; i < booksNum; i++) {
            Book book = books[i];
            if (book.getPublicationYear() > year) {
                booksPublishedAfterYear.add(book);
            }
        }

        return booksPublishedAfterYear;
    }

    public void generateBooks(int booksNum) {
        this.booksNum = Math.min(booksNum, books.length);
        for (int i = 0; i < this.booksNum; i++) {
            books[i] = BooksGenerator.generateBook();
        }
    }

    public Books getSortedByAuthorsBooks() {
        Books sortedBooks = new Books(books, booksNum);
        Arrays.sort(sortedBooks.books, new BooksAuthorsComparator());
        return sortedBooks;
    }

    public Books getSortedByPublishersBooks() {
        Books sortedBooks = new Books(books, booksNum);
        Arrays.sort(sortedBooks.books, new BooksPublishersComparator());
        return sortedBooks;
    }

    public Books getSortedByPricesDescBooks() {
        Books sortedBooks = new Books(books, booksNum);
        Arrays.sort(sortedBooks.books, new BooksPricesDescComparator());
        return sortedBooks;
    }
}
