import exceptions.BooksNumberException;
import exceptions.InvalidPercentException;
import exceptions.ShellSizeException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(sortedBooks.books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1 == null) {
                    return 1;
                }

                if (b2 == null) {
                    return -1;
                }

                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
        return sortedBooks;
    }

    public Books getSortedByPublishersBooks() {
        Books sortedBooks = new Books(books, booksNum);
        Arrays.sort(sortedBooks.books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1 == null) {
                    return 1;
                }

                if (b2 == null) {
                    return -1;
                }

                return b1.getPublisher().compareTo(b2.getPublisher());
            }
        });
        return sortedBooks;
    }

    public Books getSortedByPricesDescBooks() {
        Books sortedBooks = new Books(books, booksNum);
        Arrays.sort(sortedBooks.books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1 == null) {
                    return 1;
                }

                if (b2 == null) {
                    return -1;
                }

                if (b2.getPrice() > b1.getPrice()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return sortedBooks;
    }
}
