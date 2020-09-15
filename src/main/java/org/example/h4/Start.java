package org.example.h4;

import org.example.h3.SeinKleur;

public class Start {

    public static void main(String[] args) {
        Sein seinBijPutten = new Sein();
        Sein seinBijApeldoorn = new Sein();
        SeinKleur seinKleur;

        seinKleur = seinBijPutten.bepaalKleur(10);
        System.out.println(seinKleur);

        seinKleur = seinBijApeldoorn.bepaalKleur(120);
        System.out.println(seinKleur);

        seinKleur = seinBijApeldoorn.bepaalKleur(-10);
        System.out.println(seinKleur);
    }

}
