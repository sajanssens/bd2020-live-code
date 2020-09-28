package org.example.h4;

public class SnelheidException extends RuntimeException {

    public SnelheidException(int snelheid) {
        super("Snelheid " + snelheid + " is ongeldig!");
    }

}
