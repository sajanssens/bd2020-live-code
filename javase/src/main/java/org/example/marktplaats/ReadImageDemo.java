package org.example.marktplaats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadImageDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\temp\\me.jpg");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(bytes.length);
    }
}
