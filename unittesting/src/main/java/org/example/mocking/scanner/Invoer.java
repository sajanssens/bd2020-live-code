package org.example.mocking.scanner;

public class Invoer {

    private ScannerWrapper scannerWrapper = new ScannerWrapper();

    public static void main(String[] args) {
        String run = new Invoer().run();
        System.out.println(run);
    }

    public String run() {
        String input = scannerWrapper.read();

        int lengte = bepaalLengte(input);
        return "Lengte is: " + lengte;
    }

    private int bepaalLengte(String input) {
        return input.length();
    }

    public void setScannerWrapper(ScannerWrapper scanner) {
        this.scannerWrapper = scanner;
    }
}
