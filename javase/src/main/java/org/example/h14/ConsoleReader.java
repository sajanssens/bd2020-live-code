package org.example.h14;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return scanner.nextLine();
    }

}
