package org.example.mocking.scanner;

import java.util.Scanner;

public class ScannerWrapper {

    private Scanner scanner = new Scanner(System.in);

    public String read() {
        return scanner.nextLine();
    }

}
