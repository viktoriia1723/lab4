package com.lab4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SIZE = 5;
        Book[] books = new Book[SIZE];

        System.out.println("=== Введення даних для 5 книг ===\n");

        for (int i = 0; i < SIZE; i++) {
            System.out.println("--- Книга #" + (i + 1) + " ---");

            System.out.print("Назва: ");
            String title = scanner.nextLine();

            System.out.print("Автор: ");
            String author = scanner.nextLine();

            System.out.print("Рік видання: ");
            int year = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Ціна (грн): ");
            double price = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Кількість сторінок: ");
            int pages = Integer.parseInt(scanner.nextLine().trim());

            books[i] = new Book(title, author, year, price, pages);
            System.out.println();
        }

        scanner.close();

        System.out.println("=== Інформація про всі книги ===\n");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Книга #" + (i + 1) + ": " + books[i]);
        }

        System.out.println("\n=== Перевірка equals ===");
        System.out.println("Книга #1 == Книга #1: " + books[0].equals(books[0]));
        System.out.println("Книга #1 == Книга #2: " + books[0].equals(books[1]));
    }
}