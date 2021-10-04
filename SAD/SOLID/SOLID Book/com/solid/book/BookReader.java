// package com.solid.book;


import java.util.List;

public class BookReader {
    public static void main(String[] args) {
        BookPrinter bookPrinter = new BookPrinter(new Book("Tyland", List.of("I", "moved", "here", "recently", "too")));
        bookPrinter.printToScreen();
    }
}
