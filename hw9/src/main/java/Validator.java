import exceptions.BooksNumberException;
import exceptions.InvalidPercentException;
import exceptions.ShellSizeException;

import java.io.Serializable;

public class Validator implements Serializable {
    public void validateBooksNumber(int booksNum, int shellSize) throws BooksNumberException {
        if (booksNum >= shellSize) throw new BooksNumberException("Number of books reached shell size");
    }

    public void validatePercent(double percent) throws InvalidPercentException {
        if (percent < -100.00) throw new InvalidPercentException("Invalid percent to reprice the books");
    }

    public void validateShellSize(int shellSize) throws ShellSizeException {
        if (shellSize < 0) throw new ShellSizeException("Shell size should not be  negative number");
    }
}
