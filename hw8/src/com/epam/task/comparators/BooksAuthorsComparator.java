package com.epam.task.comparators;

import com.epam.task.Book;

import java.util.Comparator;

public class BooksAuthorsComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Book b1 = (Book) o;
        Book b2 = (Book) t1;

        if (b1 == null) {
            return 1;
        }

        if (b2 == null) {
            return -1;
        }

        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}
