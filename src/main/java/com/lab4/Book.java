package com.lab4;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;

    public Book(String title, String author, int year, double price, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.pages = pages;
    }

    // Гетери
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int getYear()      { return year; }
    public double getPrice()  { return price; }
    public int getPages()     { return pages; }

    // Сетери
    public void setTitle(String title)   { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year)        { this.year = year; }
    public void setPrice(double price)   { this.price = price; }
    public void setPages(int pages)      { this.pages = pages; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Double.compare(book.price, price) == 0 &&
                pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, price, pages);
    }
}