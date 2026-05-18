package com.lab4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DatabaseManager — handles JDBC connection and INSERT operations.
 */
public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(String configPath) {
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(configPath);
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error reading config file: " + e.getMessage());
            return;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Error closing config file: " + e.getMessage());
                }
            }
        }

        String url      = props.getProperty("db.url");
        String user     = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    public void insertBook(Book book) {
        if (connection == null) {
            System.out.println("No database connection. Cannot insert book.");
            return;
        }

        String sql = "INSERT INTO books (type, title, author, pages, price, genre, extra1, extra2) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        String type   = "";
        String extra1 = null;
        String extra2 = null;

        if (book instanceof EBook) {
            EBook e = (EBook) book;
            type   = "EBOOK";
            extra1 = String.valueOf(e.getFileSize());
        } else if (book instanceof PaperBook) {
            PaperBook p = (PaperBook) book;
            type   = "PAPERBOOK";
            extra1 = String.valueOf(p.getWeight());
        } else if (book instanceof AudioBook) {
            AudioBook a = (AudioBook) book;
            type   = "AUDIOBOOK";
            extra1 = a.getNarrator();
            extra2 = String.valueOf(a.getDurationMinutes());
        } else if (book instanceof ComicBook) {
            ComicBook c = (ComicBook) book;
            type   = "COMICBOOK";
            extra1 = c.getPublisher();
            extra2 = String.valueOf(c.getIssues());
        }

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getPages());
            stmt.setDouble(5, book.getPrice());
            stmt.setString(6, book.getGenre().toString());
            stmt.setString(7, extra1);
            stmt.setString(8, extra2);
            stmt.executeUpdate();
            System.out.println("Book saved to database: " + book.getTitle());
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement: " + e.getMessage());
                }
            }
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}