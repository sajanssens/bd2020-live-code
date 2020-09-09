package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

/**
 * Dit is mijn eerste demo. ...
 *
 * @author bramj
 * @version 1.0
 * @see ...
 */
public class Start {

    static Logger log = LoggerFactory.getLogger("mijnLogger");

    /**
     * Dit is het startpunt van mijn applicatie.
     * ...
     *
     * @param args de commandline argumenten
     */
    public static void main(String[] args) {
        String s = "";

        System.out.println("hier gebeurt iets..." + args[0]);

        // trek de wortel uit twee:
        double wortelTwee = sqrt(2);

        System.out.println(/*dit is de parameter: */ wortelTwee);
    }

}
