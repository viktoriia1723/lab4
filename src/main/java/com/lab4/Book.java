package com.lab4;

/**
 * Abstract base class Book. Implements Comparable for sorting by title.
 */
public abstract class Book implements Comparable<Book> {
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

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int    getPages()  { return pages; }
    public double getPrice()  { return price; }
    public Genre  getGenre()  { return genre; }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0");
        }
        this.pages = pages;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    public void setGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }
        this.genre = genre;
    }

    /**
     * Sorts books alphabetically by title (case-insensitive).
     */
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
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