package com.lab4;

/**
 * Derived class ComicBook.
 */
public class ComicBook extends Book {
    private String publisher;
    private int issues;

    public ComicBook(String title,
                     String author,
                     int pages,
                     double price,
                     Genre genre,
                     String publisher,
                     int issues) {
        super(title, author, pages, price, genre);
        setPublisher(publisher);
        setIssues(issues);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be empty");
        }
        this.publisher = publisher;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        if (issues <= 0) {
            throw new IllegalArgumentException("Issues must be greater than 0");
        }
        this.issues = issues;
    }

    public double getPricePerIssue() {
        return price / issues;
    }

    @Override
    public String toString() {
        return "ComicBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre=" + genre +
                ", publisher='" + publisher + '\'' +
                ", issues=" + issues +
                '}';
    }
}
