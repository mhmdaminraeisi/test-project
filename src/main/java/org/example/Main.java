package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utravel utravel = new Utravel();
        try {
            utravel.readFlights("flights.csv");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String commandLine = scanner.nextLine();
                if (commandLine.equals("exit")) {
                    break;
                }
                System.out.println(Functions.doCommand(commandLine, utravel));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}