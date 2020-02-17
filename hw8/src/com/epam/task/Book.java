package com.epam.task;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pagesNum;
    private double price;

    public Book(int id, String title, String author, String publisher, int publicationYear, int pagesNum, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.pagesNum = pagesNum;
        this.price = price;
    }

    @Override
    public String toString() {

        String strRepr = "--------\n" +
                "Book " + id + "\n" +
                "--------\n" +
                "title: " + title + "\n" +
                "author: " + author + "\n" +
                "publisher: " + publisher + "\n" +
                "year of the publication: " + publicationYear + "\n" +
                "number of pages: " + pagesNum + "\n" +
                String.format("price: %.2f\n", price) +
                "--------";
        return strRepr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
