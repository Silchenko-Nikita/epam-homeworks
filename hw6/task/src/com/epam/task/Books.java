package com.epam.task;

public class Books {
    private Book[] books;
    private int booksNum = 0;

    public Books(int shellSize) {
        this.books = new Book[shellSize];
    }

    public void view() {
        if (booksNum == 0) {
            System.out.println("Empty shell\n");
        }

        for (int i = 0; i < booksNum; i++) {
            System.out.println("Book №" + (i + 1) + ":");
            books[i].view();
            System.out.println();
        }
    }

    public void add(Book book) {
        if (booksNum == books.length) return;

        books[booksNum++] = book;
    }

    public void repriceBooks(double percent) {
        if (percent < -100) return;

        for (int i = 0; i < booksNum; i++) {
            Book book = books[i];
            double price = book.getPrice();
            book.setPrice(price + price * 0.01 * percent);
        }
    }

    public Books getAuthorsBooks(String author) {
        Books authorsBooks = new Books(booksNum);

        for (int i = 0; i < booksNum; i++) {
            Book book = books[i];
            if (book.getAuthor().equals(author)) {
                authorsBooks.add(book);
            }
        }

        return authorsBooks;
    }

    public Books getBooksPublishedAfter(int year) {
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
}
