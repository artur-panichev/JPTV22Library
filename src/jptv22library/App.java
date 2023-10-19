/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22library;

import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class App {
    private Scanner scanner;

    public App() {
        this.scanner = new Scanner(System.in);
    }
    
    void run() {
        boolean repeat = true;
        System.out.println("------ Library ------");
        do{
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.print("Enter number task:");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
        }while(repeat);
    }
    
}
