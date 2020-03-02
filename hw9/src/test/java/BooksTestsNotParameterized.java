import exceptions.BooksNumberException;
import exceptions.ShellSizeException;
import org.junit.Assert;
import org.junit.Test;

public class BooksTestsNotParameterized {
    @Test
    public void testGetBooksNum() throws ShellSizeException, BooksNumberException {
        Books books = new Books(10);
        books.add(BooksGenerator.generateBook());
        books.add(BooksGenerator.generateBook());

        int expectedBooksNumber = 2;
        int actualBooksNumber = books.getBooksNum();
        Assert.assertEquals("Actual books number doesn't equal expected one", expectedBooksNumber, actualBooksNumber);
    }

    @Test
    public void testAddBookHappyPath() throws ShellSizeException, BooksNumberException {
        Books books = new Books(10);

        Book[] addedBooks = new Book[] { BooksGenerator.generateBook(), BooksGenerator.generateBook() };

        books.add(addedBooks[0]);
        books.add(addedBooks[1]);

        Book[] actualBooksArray = books.getBooks();
        Assert.assertEquals("Actual books don't equal expected", addedBooks, actualBooksArray);
    }

    @Test(expected = BooksNumberException.class)
    public void testAddBookUnhappyPathWhenBooksNumIsInvalidBeingBiggerThenShellSize() throws ShellSizeException, BooksNumberException {
        Books books = new Books(0);
        books.add(BooksGenerator.generateBook());
    }
}
