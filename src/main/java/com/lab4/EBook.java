package com.lab4;

/**
 * Derived class EBook.
 */
public class EBook extends Book {

    private double fileSize;

    public EBook(String title,
                 String author,
                 int pages,
                 double price,
                 Genre genre,
                 double fileSize) {

        super(title, author, pages, price, genre);

        setFileSize(fileSize);
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {

        if (fileSize <= 0) {
            throw new IllegalArgumentException("File size must be greater than 0");
        }

        this.fileSize = fileSize;
    }

    @Override
    public String toString() {

        return "EBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre=" + genre +
                ", fileSize=" + fileSize +
                '}';
    }
}