package org.example;

import org.example.h3.Employee;
import org.example.h3.Sein;
import org.example.h3.SeinKleur;
import org.example.h4.Loops;

/**
 * Dit is mijn eerste demo. ...
 *
 * @author bramj
 * @version 1.0
 * @see ...
 */
public class Start {

    /**
     * Dit is het startpunt van mijn applicatie.
     * ...
     *
     * @param args de commandline argumenten
     */
    public static void main(String[] args) {
        // Sein.demoOperators();

        // create object:
        Employee bram;
        bram = new Employee();
        bram.firstname = "Bram";
        bram.lastname = "Janssens";
        bram.age = 41;

        SeinKleur seinKleur = Sein.bepaalKleur(25);
        System.out.println(seinKleur);

        Sein.demoInitieleWaarde();

        Loops.loopsDemo();
    }

}
