package com.lab4;

/**
 * Derived class PaperBook.
 */
public class PaperBook extends Book {

    private double weight;

    public PaperBook(String title,
                     String author,
                     int pages,
                     double price,
                     Genre genre,
                     double weight) {

        super(title, author, pages, price, genre);

        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        this.weight = weight;
    }

    @Override
    public String toString() {

        return "PaperBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre=" + genre +
                ", weight=" + weight +
                '}';
    }
}