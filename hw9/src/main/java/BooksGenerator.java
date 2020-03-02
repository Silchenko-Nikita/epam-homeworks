public class BooksGenerator {
    public static final String[] BOOK_TITLES = {
            "Garry Potter",
            "Age of mine",
            "Somebody",
            "Who is America?",
            "Who killed the officer?",
            "Mein kampf",
            "Generation lambda"
    };

    public static final String[] AUTHORS = {
            "Joanne Rowling",
            "Adolf Hitler",
            "Robert Johnson",
            "Nikita Silchenko",
            "John Galt",
            "Elizabeth Robertson",
            "Boris Zhukovsky"
    };

    public static final String[] PUBLISHERS = {
            "Nowadays",
            "Hello world",
            "Foo too",
            "Jinga",
            "Our souls"
    };

    public static Book generateBook() {
        return new Book((int) (Math.random() * 10000),
                                BOOK_TITLES[(int) (Math.random() * BOOK_TITLES.length)],
                                AUTHORS[(int) (Math.random() * AUTHORS.length)],
                                PUBLISHERS[ (int) (Math.random() * PUBLISHERS.length)],
                                (int) (Math.random() * 520 + 1500),
                                (int) (Math.random() * 700 + 300),
                            Math.random() * 300 + 100);
    };
}
