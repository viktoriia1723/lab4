package com.lab4;

/**
 * Derived class AudioBook.
 */
public class AudioBook extends Book {
    private String narrator;
    private int durationMinutes;

    public AudioBook(String title,
                     String author,
                     int pages,
                     double price,
                     Genre genre,
                     String narrator,
                     int durationMinutes) {
        super(title, author, pages, price, genre);
        setNarrator(narrator);
        setDurationMinutes(durationMinutes);
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        if (narrator == null || narrator.trim().isEmpty()) {
            throw new IllegalArgumentException("Narrator cannot be empty");
        }
        this.narrator = narrator;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.durationMinutes = durationMinutes;
    }

    public String getFormattedDuration() {
        int hours = durationMinutes / 60;
        int minutes = durationMinutes % 60;
        return hours + "h " + String.format("%02d", minutes) + "min";
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre=" + genre +
                ", narrator='" + narrator + '\'' +
                ", duration=" + getFormattedDuration() +
                '}';
    }
}