package com.lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add book");
            System.out.println("2. Show all books");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());

                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        Book book = new Book(title, author, pages, price);
                        books.add(book);

                        System.out.println("Book added!");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}