package org.example.mocking.console;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return scanner.nextLine();
    }

}
