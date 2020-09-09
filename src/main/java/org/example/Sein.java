package org.example;

public class Sein {

    static String bepaalKleur(int snelheid) {
        String kleur = "onbekend";

        if (snelheid <= 30) {
            kleur = "groen";
        } else if (snelheid <= 50) {
            kleur = "oranje";
        } else {
            kleur = "rood";
        }

        return kleur;
    }
}
