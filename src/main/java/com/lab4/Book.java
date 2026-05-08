package com.lab4;

/**
 * Base class Book.
 */
public class Book {

    protected String title;
    protected String author;
    protected int pages;
    protected double price;
    protected Genre genre;

    public Book(String title,
                String author,
                int pages,
                double price,
                Genre genre) {

        setTitle(title);
        setAuthor(author);
        setPages(pages);
        setPrice(price);
        setGenre(genre);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }

        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {

        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0");
        }

        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {

        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }

        this.genre = genre;
    }

    @Override
    public String toString() {

        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre=" + genre +
                '}';
    }
}