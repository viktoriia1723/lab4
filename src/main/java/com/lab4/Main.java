package com.lab4;

import java.util.Scanner;

/**
 * Driver class for program testing.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library("City Library");

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add book");
            System.out.println("2. Show all books");
            System.out.println("3. Show number of books");
            System.out.println("4. Create copy of first book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    try {

                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.println("Choose genre:");
                        System.out.println("1. FANTASY");
                        System.out.println("2. SCIENCE");
                        System.out.println("3. HISTORY");
                        System.out.println("4. ROMANCE");
                        System.out.println("5. DETECTIVE");

                        int genreChoice = Integer.parseInt(scanner.nextLine());

                        Genre genre;

                        switch (genreChoice) {

                            case 1:
                                genre = Genre.FANTASY;
                                break;

                            case 2:
                                genre = Genre.SCIENCE;
                                break;

                            case 3:
                                genre = Genre.HISTORY;
                                break;

                            case 4:
                                genre = Genre.ROMANCE;
                                break;

                            case 5:
                                genre = Genre.DETECTIVE;
                                break;

                            default:
                                System.out.println("Invalid genre!");
                                continue;
                        }

                        Book book = new Book(
                                title,
                                author,
                                pages,
                                price,
                                genre
                        );

                        library.addBook(book);

                        System.out.println("Book added successfully!");

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid numeric input!");

                    } catch (IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case "2":

                    library.showBooks();
                    break;

                case "3":

                    System.out.println("Books created: " + Book.getBookCount());
                    break;

                case "4":

                    if (library.getBooks().size() > 0) {

                        Book copyBook = new Book(library.getBooks().get(0));

                        System.out.println("Copy created:");
                        System.out.println(copyBook);

                    } else {

                        System.out.println("Library is empty!");
                    }

                    break;

                case "5":

                    System.out.println("Program finished.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid menu option!");
            }
        }
    }
}