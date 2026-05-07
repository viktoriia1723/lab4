package com.lab4;

public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;

    public Book(String title, String author, int pages, double price) {
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be > 0");
        }
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", pages: " + pages + ", price: " + price;
    }
}