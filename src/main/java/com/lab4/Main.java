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
            System.out.println("1. Add EBook");
            System.out.println("2. Add PaperBook");
            System.out.println("3. Show all books");
            System.out.println("4. Exit");
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

                        System.out.print("Enter file size: ");
                        double fileSize = Double.parseDouble(scanner.nextLine());

                        EBook ebook = new EBook(
                                title,
                                author,
                                pages,
                                price,
                                Genre.FANTASY,
                                fileSize
                        );

                        books.add(ebook);

                        System.out.println("EBook added!");

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid numeric input!");

                    } catch (IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case "2":

                    try {

                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter weight: ");
                        double weight = Double.parseDouble(scanner.nextLine());

                        PaperBook paperBook = new PaperBook(
                                title,
                                author,
                                pages,
                                price,
                                Genre.HISTORY,
                                weight
                        );

                        books.add(paperBook);

                        System.out.println("PaperBook added!");

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid numeric input!");

                    } catch (IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case "3":

                    if (books.isEmpty()) {

                        System.out.println("No books found.");

                    } else {

                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }

                    break;

                case "4":

                    System.out.println("Program finished.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid option!");
            }
        }
    }
}