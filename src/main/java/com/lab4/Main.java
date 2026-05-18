package com.lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Driver class.
 */
public class Main {

    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = loadFromFile();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Search book");
            System.out.println("2. Add new book");
            System.out.println("3. Show all books");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchMenu(scanner, library);
                    break;
                case "2":
                    addBook(scanner, library);
                    break;
                case "3":
                    library.printAllBooks();
                    break;
                case "4":
                    saveToFile(library);
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // -------------------------------------------------------------------------
    //  Search menu
    // -------------------------------------------------------------------------

    private static void searchMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Search by ---");
        System.out.println("1. Genre");
        System.out.println("2. Author");
        System.out.println("3. Max price");
        System.out.println("0. Back to main menu");
        System.out.print("Choose criterion: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Select genre:");
                System.out.println("1. FANTASY");
                System.out.println("2. SCIENCE");
                System.out.println("3. HISTORY");
                System.out.println("4. ROMANCE");
                System.out.println("5. DETECTIVE");
                System.out.print("Choose genre: ");
                String genreChoice = scanner.nextLine();
                Genre genre;
                switch (genreChoice) {
                    case "1": genre = Genre.FANTASY;   break;
                    case "2": genre = Genre.SCIENCE;   break;
                    case "3": genre = Genre.HISTORY;   break;
                    case "4": genre = Genre.ROMANCE;   break;
                    case "5": genre = Genre.DETECTIVE; break;
                    default:
                        System.out.println("Invalid genre choice!");
                        return;
                }
                printResults(library.searchByGenre(genre));
                break;
            case "2":
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                printResults(library.searchByAuthor(author));
                break;
            case "3":
                try {
                    System.out.print("Enter max price: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    printResults(library.searchByMaxPrice(maxPrice));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid numeric input!");
                }
                break;
            case "0":
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private static void printResults(ArrayList<Book> results) {
        if (results.isEmpty()) {
            System.out.println("No books found matching the criteria.");
        } else {
            System.out.println("Found " + results.size() + " book(s):");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    // -------------------------------------------------------------------------
    //  Add book via menu
    // -------------------------------------------------------------------------

    private static void addBook(Scanner scanner, Library library) {
        System.out.println("\n--- Select book type ---");
        System.out.println("1. EBook");
        System.out.println("2. PaperBook");
        System.out.println("3. AudioBook");
        System.out.println("4. ComicBook");
        System.out.println("0. Back to main menu");
        System.out.print("Choose type: ");
        String typeChoice = scanner.nextLine();

        if (typeChoice.equals("0")) {
            System.out.println("Returning to main menu.");
            return;
        }

        if (!typeChoice.equals("1") && !typeChoice.equals("2")
                && !typeChoice.equals("3") && !typeChoice.equals("4")) {
            System.out.println("Invalid type!");
            return;
        }

        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Select genre:");
            System.out.println("1. FANTASY");
            System.out.println("2. SCIENCE");
            System.out.println("3. HISTORY");
            System.out.println("4. ROMANCE");
            System.out.println("5. DETECTIVE");
            System.out.print("Choose genre: ");
            String genreChoice = scanner.nextLine();
            Genre genre;
            switch (genreChoice) {
                case "1": genre = Genre.FANTASY;   break;
                case "2": genre = Genre.SCIENCE;   break;
                case "3": genre = Genre.HISTORY;   break;
                case "4": genre = Genre.ROMANCE;   break;
                case "5": genre = Genre.DETECTIVE; break;
                default: throw new IllegalArgumentException("Invalid genre choice");
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Book book = null;

            switch (typeChoice) {
                case "1": {
                    System.out.print("Enter file size (MB): ");
                    double fileSize = Double.parseDouble(scanner.nextLine());
                    book = new EBook(title, author, pages, price, genre, fileSize);
                    break;
                }
                case "2": {
                    System.out.print("Enter weight (kg): ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    book = new PaperBook(title, author, pages, price, genre, weight);
                    break;
                }
                case "3": {
                    System.out.print("Enter narrator: ");
                    String narrator = scanner.nextLine();
                    System.out.print("Enter duration (minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    book = new AudioBook(title, author, pages, price, genre, narrator, duration);
                    break;
                }
                case "4": {
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter number of issues: ");
                    int issues = Integer.parseInt(scanner.nextLine());
                    book = new ComicBook(title, author, pages, price, genre, publisher, issues);
                    break;
                }
                default:
                    break;
            }

            if (book != null) {
                library.addNewBook(book, quantity);
                System.out.println("Book added to library!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  File operations
    // -------------------------------------------------------------------------

    public static Library loadFromFile() {
        Library library = new Library("Default Library", "Unknown Address");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    if (line.startsWith("LIBRARY|")) {
                        String[] parts = line.split("\\|");
                        if (parts.length >= 3) {
                            library = new Library(parts[1].trim(), parts[2].trim());
                        }
                    } else {
                        String[] parts = line.split("\\|");
                        int quantity = Integer.parseInt(parts[parts.length - 1].trim());
                        String bookLine = line.substring(0, line.lastIndexOf("|"));
                        Book book = parseLine(bookLine);
                        if (book != null) {
                            library.addNewBook(book, quantity);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Skipping invalid line " + lineNumber + ": " + e.getMessage());
                }
            }
            System.out.println("Loaded library: " + library.getName());
            System.out.println("Loaded " + library.getTotalDistinctBooks() + " book(s) from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("File not found or cannot be read. Starting with empty library.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
        return library;
    }

    private static Book parseLine(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 7) {
            throw new IllegalArgumentException("Not enough fields: " + line);
        }

        String type   = parts[0].trim().toUpperCase();
        String title  = parts[1].trim();
        String author = parts[2].trim();
        int pages     = Integer.parseInt(parts[3].trim());
        double price  = Double.parseDouble(parts[4].trim());
        Genre genre   = Genre.valueOf(parts[5].trim().toUpperCase());

        switch (type) {
            case "EBOOK": {
                double fileSize = Double.parseDouble(parts[6].trim());
                return new EBook(title, author, pages, price, genre, fileSize);
            }
            case "PAPERBOOK": {
                double weight = Double.parseDouble(parts[6].trim());
                return new PaperBook(title, author, pages, price, genre, weight);
            }
            case "AUDIOBOOK": {
                if (parts.length < 8) {
                    throw new IllegalArgumentException("AudioBook requires 8 fields: " + line);
                }
                String narrator     = parts[6].trim();
                int durationMinutes = Integer.parseInt(parts[7].trim());
                return new AudioBook(title, author, pages, price, genre, narrator, durationMinutes);
            }
            case "COMICBOOK": {
                if (parts.length < 8) {
                    throw new IllegalArgumentException("ComicBook requires 8 fields: " + line);
                }
                String publisher = parts[6].trim();
                int issues       = Integer.parseInt(parts[7].trim());
                return new ComicBook(title, author, pages, price, genre, publisher, issues);
            }
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }

    public static void saveToFile(Library library) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write("LIBRARY|" + library.getName() + "|" + library.getAddress());
            writer.newLine();
            ArrayList<Book> books = library.getBooks();
            for (int i = 0; i < books.size(); i++) {
                writer.write(toFileLine(books.get(i)) + "|" + library.getQuantity(i));
                writer.newLine();
            }
            System.out.println("Saved " + library.getTotalDistinctBooks() + " book(s) to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    private static String toFileLine(Book book) {
        if (book instanceof EBook) {
            EBook e = (EBook) book;
            return "EBOOK|" + e.getTitle() + "|" + e.getAuthor() + "|"
                    + e.getPages() + "|" + e.getPrice() + "|"
                    + e.getGenre() + "|" + e.getFileSize();
        } else if (book instanceof PaperBook) {
            PaperBook p = (PaperBook) book;
            return "PAPERBOOK|" + p.getTitle() + "|" + p.getAuthor() + "|"
                    + p.getPages() + "|" + p.getPrice() + "|"
                    + p.getGenre() + "|" + p.getWeight();
        } else if (book instanceof AudioBook) {
            AudioBook a = (AudioBook) book;
            return "AUDIOBOOK|" + a.getTitle() + "|" + a.getAuthor() + "|"
                    + a.getPages() + "|" + a.getPrice() + "|"
                    + a.getGenre() + "|" + a.getNarrator() + "|" + a.getDurationMinutes();
        } else if (book instanceof ComicBook) {
            ComicBook c = (ComicBook) book;
            return "COMICBOOK|" + c.getTitle() + "|" + c.getAuthor() + "|"
                    + c.getPages() + "|" + c.getPrice() + "|"
                    + c.getGenre() + "|" + c.getPublisher() + "|" + c.getIssues();
        }
        return "";
    }
}