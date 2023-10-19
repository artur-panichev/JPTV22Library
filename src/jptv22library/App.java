/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22library;

import entity.Book;
import entity.Reader;
import java.util.Arrays;
import managers.BookManager;
import managers.ReaderManager;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class App {
    private Scanner scanner;
    private Book[] books = new Book[0];
    private Reader[] readers = new Reader[0];
    public App() {
        this.scanner = new Scanner(System.in);
    }
    
    void run() {
        boolean repeat = true;
        System.out.println("------ Library ------");
        do{
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Add new reader");
            System.out.println("3. Print list books");
            System.out.println("4. Print list readers");
            System.out.print("Enter number task:");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    BookManager bookManager;
                    bookManager = new BookManager(scanner);
                    addBookToBooks(bookManager.addBook());
                    break;
                case 2:
                    ReaderManager readerManager;
                    readerManager = new ReaderManager(scanner);
                    addReaderToReaders(readerManager.addReader());
                    break;
                case 3:
                    bookManager = new BookManager(scanner);
                    bookManager.pirntListBooks(books);
                    break;
                case 4:
                    readerManager = new ReaderManager(scanner);
                    readerManager.pirntListReaders(readers);
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
        }while(repeat);
    }

    private void addBookToBooks(Book book) {
        this.books = Arrays.copyOf(this.books, this.books.length + 1);
        this.books[this.books.length - 1] = book;
    }

    private void addReaderToReaders(Reader reader) {
        this.readers = Arrays.copyOf(this.readers, this.readers.length + 1);
        this.readers[this.readers.length - 1] = reader;
        
    }
    
}
