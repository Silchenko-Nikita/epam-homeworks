package com.epam.task;

import com.epam.task.exceptions.BooksNumberException;
import com.epam.task.exceptions.InvalidPercentException;
import com.epam.task.exceptions.ShellSizeException;

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
