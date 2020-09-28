package org.example.h5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public String read(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            return br.readLine();
        } catch (IOException ex) {
            // handle ex ...
        } finally {
            // null.methode();
            if (br != null) {
                try {
                    br.close(); // NullPointerException
                } catch (IOException e) {
                    // handle ex ...
                }
            }
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(path))) {
            return br2.readLine();
        } catch (IOException ex) {
            // handle ex ...
        }
        //  br is closed

        return path;
    }

}
