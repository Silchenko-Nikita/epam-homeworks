import exceptions.BooksNumberException;
import exceptions.InvalidPercentException;
import exceptions.ShellSizeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value= Parameterized.class)
public class BooksTestsParameterized {
    @Parameterized.Parameter
    public int validShellSize;
    @Parameterized.Parameter(1)
    public int invalidShellSize;
    @Parameterized.Parameter(2)
    public int validBooksNum;
    @Parameterized.Parameter(3)
    public int invalidBooksNum;
    @Parameterized.Parameter(4)
    public double percentToReprice;
    @Parameterized.Parameter(5)
    public int year;
    @Parameterized.Parameter(6)
    public int[] booksPublishingYears;
    @Parameterized.Parameter(7)
    public String[] authors;
    @Parameterized.Parameter(8)
    public String[] publishers;
    @Parameterized.Parameter(9)
    public double[] prices;

    @Parameterized.Parameters(
            name="{index}:validShellSize={0}, invalidShellSize={1}, validBooksNum={2}, invalidBooksNum={3}, ...")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {5,-1, 5, 10, -20.0, 1700, new int[] {1500, 1700, 1800}, new String[] {"John", "James", "Kant"}, new String[] {"A", "D", "B"}, new double[] {200.00, 150.00, 250.00}},
                {20, -10, 10, 21, 0.0, 1800, new int[] {1870, 1980, 1970}, new String[] {"A", "D", "B"}, new String[] {"Yahoo", "Google", "Facebook"}, new double[] {200.00, 200.05, 100.00}},
                {0, -5, 0, 1, 40.0, 1900, new int[] {1870, 1880, 1889}, new String[] {"C", "B", "C"}, new String[] {"C", "B", "C"}, new double[] {100.00, 100.00, 100.00}},
        });
    }

    @Test
    public void testBooksCreationHappyPath() throws ShellSizeException {
        Books books = new Books(validShellSize);
        int actualShellSize = books.getShellSize();
        Assert.assertEquals("Actual shell size doesn't equal expected one", validShellSize, actualShellSize);
    }

    @Test(expected = ShellSizeException.class)
    public void testBooksCreationUnhappyPathWhenShellSizeIsInvalid() throws ShellSizeException {
        Books books = new Books(invalidShellSize);
    }

    @Test
    public void testGenerateBooksHappyPath() throws ShellSizeException, BooksNumberException {
        Books books = new Books(validShellSize);
        books.generateBooks(validBooksNum);
        int actualBooksNumber = books.getBooksNum();
        Assert.assertEquals("Actual books number doesn't equal expected one", validBooksNum, actualBooksNumber);
    }

    @Test(expected = BooksNumberException.class)
    public void testGenerateBooksUnhappyPathWhenBooksToGenerateNumIsInvalid() throws ShellSizeException, BooksNumberException {
        Books books = new Books(validShellSize);
        books.generateBooks(invalidBooksNum);
    }


    @Test
    public void testRepriceBooks() throws ShellSizeException, BooksNumberException, InvalidPercentException {
        Books books = new Books(10);

        Book[] addedBooks = new Book[] { BooksGenerator.generateBook(), BooksGenerator.generateBook() };

        books.add(addedBooks[0]);
        books.add(addedBooks[1]);

        double[] pricesBeforeReprice = { addedBooks[0].getPrice(), addedBooks[1].getPrice() };
        books.repriceBooks(percentToReprice);
        double[] pricesAfterReprice = { addedBooks[0].getPrice(), addedBooks[1].getPrice() };

        double[] expectedPricesAfterReprice = {
                pricesBeforeReprice[0] * (1 + 0.01 * percentToReprice),
                pricesBeforeReprice[1] * (1 + 0.01 * percentToReprice)
        };

        for (int i = 0; i < pricesAfterReprice.length; i++) {
            Assert.assertEquals("Actual books price after reprice don't equal expected",
                    expectedPricesAfterReprice[i],
                    pricesAfterReprice[i], 0.001);
        }
    }

    @Test
    public void testGetSortedByAuthorsBooks() throws ShellSizeException, BooksNumberException {
        Books books = new Books(10);

        for (String author : authors) {
            books.add(new Book((int) (Math.random() * 10000),
                    BooksGenerator.BOOK_TITLES[(int) (Math.random() * BooksGenerator.BOOK_TITLES.length)],
                    author,
                    BooksGenerator.PUBLISHERS[(int) (Math.random() * BooksGenerator.PUBLISHERS.length)],
                    (int) (Math.random() * 520 + 1500),
                    (int) (Math.random() * 700 + 300),
                    Math.random() * 300 + 100));
        }

        Book[] booksSortedByAuthorsNames = books.getSortedByAuthorsBooks().getBooks();

        for (int i = 0; i < booksSortedByAuthorsNames.length - 1; i++) {
            Assert.assertTrue("getSortedByAuthorsBooks method returned books that aren't sorted by author's name",
                    booksSortedByAuthorsNames[i].getAuthor().compareTo(booksSortedByAuthorsNames[i + 1].getAuthor()) <= 0);
        }
    }

    @Test
    public void testGetSortedByPublishersBooks() throws ShellSizeException, BooksNumberException {
        Books books = new Books(10);

        for (String publisher : publishers) {
            books.add(new Book((int) (Math.random() * 10000),
                    BooksGenerator.BOOK_TITLES[(int) (Math.random() * BooksGenerator.BOOK_TITLES.length)],
                    BooksGenerator.AUTHORS[(int) (Math.random() * BooksGenerator.AUTHORS.length)],
                    publisher,
                    (int) (Math.random() * 520 + 1500),
                    (int) (Math.random() * 700 + 300),
                    Math.random() * 300 + 100));
        }

        Book[] booksSortedByPublisherNames = books.getSortedByPublishersBooks().getBooks();

        for (int i = 0; i < booksSortedByPublisherNames.length - 1; i++) {
            Assert.assertTrue("getSortedByPublishersBooks method returned books that aren't sorted by publisher's name",
                    booksSortedByPublisherNames[i].getPublisher().compareTo(booksSortedByPublisherNames[i + 1].getPublisher()) <= 0);
        }
    }

    @Test
    public void testGetSortedByPricesDescBooks() throws ShellSizeException, BooksNumberException {
        Books books = new Books(10);

        for (double price : prices) {
            books.add(new Book((int) (Math.random() * 10000),
                    BooksGenerator.BOOK_TITLES[(int) (Math.random() * BooksGenerator.BOOK_TITLES.length)],
                    BooksGenerator.AUTHORS[(int) (Math.random() * BooksGenerator.AUTHORS.length)],
                    BooksGenerator.PUBLISHERS[(int) (Math.random() * BooksGenerator.PUBLISHERS.length)],
                    (int) (Math.random() * 520 + 1500),
                    (int) (Math.random() * 700 + 300),
                    price));
        }

        Book[] booksSortedByPricesDescNames = books.getSortedByPricesDescBooks().getBooks();

        for (int i = 0; i < booksSortedByPricesDescNames.length - 1; i++) {
            Assert.assertTrue("getSortedByPricesDescBooks method returned books that aren't sorted by price in descending order",
                    booksSortedByPricesDescNames[i].getPrice() >= booksSortedByPricesDescNames[i + 1].getPrice());
        }
    }

    @Test
    public void testGetBooksPublishedAfterYear() throws ShellSizeException, BooksNumberException, InvalidPercentException {
        Books books = new Books(10);

        for (int booksPublishingYear : booksPublishingYears) {
            books.add(new Book((int) (Math.random() * 10000),
                    BooksGenerator.BOOK_TITLES[(int) (Math.random() * BooksGenerator.BOOK_TITLES.length)],
                    BooksGenerator.AUTHORS[(int) (Math.random() * BooksGenerator.AUTHORS.length)],
                    BooksGenerator.PUBLISHERS[(int) (Math.random() * BooksGenerator.PUBLISHERS.length)],
                    booksPublishingYear,
                    (int) (Math.random() * 700 + 300),
                    Math.random() * 300 + 100));
        }

        Book[] booksPublishedAfterYear = books.getBooksPublishedAfter(year).getBooks();

        for (int i = 0; i < booksPublishedAfterYear.length; i++) {
            Assert.assertTrue("booksPublishedAfter method returned book that wasn't published after speciafied year",
                    booksPublishedAfterYear[i].getPublicationYear() > year);
        }
    }
}
