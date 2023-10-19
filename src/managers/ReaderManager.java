/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class ReaderManager {

    private final Scanner scanner;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader addReader() {
        System.out.println(" ----- Add new reader -----");
        Reader reader = new Reader();
        System.out.println("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader " + reader.toString());
        return reader;
    }

    public void pirntListReaders(Reader[] readers) {
        System.out.println("------ List books -------");
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s. %s. %s%n",
                    i+1,
                    readers[i].getFirstname(),
                    readers[i].getLastname(),
                    readers[i].getPhone()
            );
                   
        }
    }
    
    
}
