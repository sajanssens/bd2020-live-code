package org.example.h3;

public class Sein {

    static String classScopeKleur;

    static Integer aantalLampen2;
    static int aantalLampen; // class variabelen krijgen WEL automatische beginwaarde
    static boolean test;
    static char kar;

    public static SeinKleur bepaalKleur(int snelheid) {
        SeinKleur kleur;

        if (snelheid <= 30) {
            kleur = SeinKleur.GROEN;
        } else if (snelheid <= 50) {
            kleur = SeinKleur.ORANJE;
        } else {
            kleur = SeinKleur.ROOD;
        }

        return kleur;
    }

    public static String demoInitieleWaarde() {
        System.out.println(aantalLampen);
        System.out.println(aantalLampen2);
        System.out.println(test);
        System.out.println(kar);
        System.out.println(classScopeKleur);
        return "XYZ!";
    }

}
