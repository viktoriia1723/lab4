package com.lab4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add new book");
            System.out.println("2. Show all books");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook(scanner, books);
                    break;
                case "2":
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                    break;
                case "3":
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addBook(Scanner scanner, ArrayList<Book> books) {
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
            Genre genre = switch (genreChoice) {
                case "1" -> Genre.FANTASY;
                case "2" -> Genre.SCIENCE;
                case "3" -> Genre.HISTORY;
                case "4" -> Genre.ROMANCE;
                case "5" -> Genre.DETECTIVE;
                default -> throw new IllegalArgumentException("Invalid genre choice");
            };

            switch (typeChoice) {
                case "1": {
                    System.out.print("Enter file size (MB): ");
                    double fileSize = Double.parseDouble(scanner.nextLine());
                    EBook ebook = new EBook(title, author, pages, price, genre, fileSize);
                    books.add(ebook);
                    System.out.println("EBook added!");
                    break;
                }
                case "2": {
                    System.out.print("Enter weight (kg): ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    PaperBook paperBook = new PaperBook(title, author, pages, price, genre, weight);
                    books.add(paperBook);
                    System.out.println("PaperBook added!");
                    break;
                }
                case "3": {
                    System.out.print("Enter narrator: ");
                    String narrator = scanner.nextLine();
                    System.out.print("Enter duration (minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    AudioBook audioBook = new AudioBook(title, author, pages, price, genre, narrator, duration);
                    books.add(audioBook);
                    System.out.println("AudioBook added!");
                    break;
                }
                case "4": {
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter number of issues: ");
                    int issues = Integer.parseInt(scanner.nextLine());
                    ComicBook comicBook = new ComicBook(title, author, pages, price, genre, publisher, issues);
                    books.add(comicBook);
                    System.out.println("ComicBook added!");
                    break;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}