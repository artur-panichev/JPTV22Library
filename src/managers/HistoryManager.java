/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 *
 * @author pupil
 */
public class HistoryManager{
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    
    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
    }
    public History giveOutBook(Book[] books, Reader[] readers){
        History history = new History();
        readerManager.printListReaders(readers);
        int selectedReaderNumber = scanner.nextInt(); scanner.nextLine();
        history.setReader(readers[selectedReaderNumber-1]);
        bookManager.printListBooks(books);
        int selectedBookNumber = scanner.nextInt(); scanner.nextLine();
        history.setBook(books[selectedBookNumber-1]);
        history.setDateOnHand(new GregorianCalendar().getTime());
        return history;
    }

    public void returnBook(History[] histories) {
        bookManager.listReadingBooks(histories);
        System.out.print("Select book for return: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned%n", 
                histories[historyNumber-1].getBook().getTitle()
        );
    }
}