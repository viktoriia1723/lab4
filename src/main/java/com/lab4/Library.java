package com.lab4;

import java.util.ArrayList;

/**
 * Library class — container for books with quantity tracking.
 */
public class Library {

    private String name;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Integer> quantities;

    public Library(String name, String address) {
        setName(name);
        setAddress(address);
        this.books      = new ArrayList<Book>();
        this.quantities = new ArrayList<Integer>();
    }

    public String getName()    { return name; }
    public String getAddress() { return address; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Library name cannot be empty");
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Library address cannot be empty");
        }
        this.address = address;
    }

    public void addNewBook(Book bk, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        for (int i = 0; i < books.size(); i++) {
            Book existing = books.get(i);
            if (existing.getTitle().equalsIgnoreCase(bk.getTitle())
                    && existing.getAuthor().equalsIgnoreCase(bk.getAuthor())) {
                quantities.set(i, quantities.get(i) + quantity);
                System.out.println("Quantity updated for: " + bk.getTitle());
                return;
            }
        }
        books.add(bk);
        quantities.add(quantity);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int getQuantity(int index) {
        return quantities.get(index);
    }

    public int getTotalDistinctBooks() {
        return books.size();
    }

    public ArrayList<Book> searchByGenre(Genre genre) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByMaxPrice(double maxPrice) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getPrice() <= maxPrice) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("Library: " + name + " | Address: " + address);
        System.out.println("Total distinct books: " + books.size());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i) + " | Quantity: " + quantities.get(i));
        }
    }

    @Override
    public String toString() {
        return "Library{name='" + name + "', address='" + address
                + "', books=" + books.size() + "}";
    }
}