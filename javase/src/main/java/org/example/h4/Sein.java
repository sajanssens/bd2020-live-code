package org.example.h4;

import org.example.h3.SeinKleur;

public class Sein {

    static String classScopeKleur;

    static Integer aantalLampen2;
    static int aantalLampen; // class variabelen krijgen WEL automatische beginwaarde
    static boolean test;
    static char kar;

    int getal = 0;

    public SeinKleur bepaalKleur(int snelheid) throws SnelheidException {
        SeinKleur kleur;

        int getal = 1;

        System.out.println(getal);

        if (snelheid > 0 && snelheid <= 30) {
            kleur = SeinKleur.GROEN;
        } else if (snelheid > 0 && snelheid <= 50) {
            kleur = SeinKleur.ORANJE;
        } else if (snelheid > 0 && snelheid <= 120) {
            kleur = SeinKleur.ROOD;
        } else {
            // return "Het ging fout; snelheid niet bekend.";
            throw new SnelheidException(snelheid);
        }

        return kleur;
    }

    public String demoInitieleWaarde() {
        bepaalKleur(9);

        System.out.println(aantalLampen);
        System.out.println(aantalLampen2);
        System.out.println(test);
        System.out.println(kar);
        System.out.println(classScopeKleur);
        return "XYZ!";
    }

    public void doeIets() {
        System.out.println("hoi");
        int i = 1 + 2;
        if (i > 0){
            return; // breek uit de methode
        }

        System.out.println("hallo");
    }

}
