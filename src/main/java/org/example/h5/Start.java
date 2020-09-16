package org.example.h5;

public class Start {

    public static void main(String[] args) {
        Calculator rekenmachine = new Calculator();

        int x = 1;
        int returnValue = rekenmachine.addOne(x);
        System.out.println(x); // ?
        System.out.println(returnValue); // ?

        Getal g = new Getal();
        g.inhoud = 1;
        rekenmachine.addOne(g);
        System.out.println(g.inhoud);

        String naam = "Bram";
        rekenmachine.addOne(naam);
        System.out.println(naam);

        Integer i = 1;
        rekenmachine.addOne(i);
        System.out.println(i);

        double average = rekenmachine.average(1, 2, 3);
        System.out.println(average);
    }

}
