package org.example.mocking.console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleApp {

    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();

    public void run() {
        String s1 = consoleReader.read();
        String s2 = consoleReader.read();
        String s3 = consoleReader.read();

        List<String> items = new ArrayList<>();
        items.add(s1);
        items.add(s2);
        items.add(s3);

        for (String i : items) {
            if (i.indexOf("P") != 0) {
                // System.out.println(i + " ");
                consoleWriter.write(i + " ");
            }
        }
        consoleWriter.write("");
    }

    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public void setConsoleReader(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }
}
