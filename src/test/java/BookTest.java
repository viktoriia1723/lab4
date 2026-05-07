package com.lab4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldThrowExceptionWhenInvalidPages() {
        Book book = new Book("Test", "Author", 100, 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPages(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", -1, 0);
        });
    }
}