package org.example.h5;

public class Start {

    public static void main(String[] args) {
        Calculator rekenmachine = new Calculator();

        int x = 1;
        int returnValue = rekenmachine.addOne(x);
        System.out.println(returnValue); // ?

        Getal g = new Getal();
        g.inhoud = 1;
        rekenmachine.addOne(g);
        System.out.println(g.inhoud);

        double average = rekenmachine.average(1, 2, 3);
        System.out.println(average);

        double average2 = rekenmachine.average2(new int[]{1, 2, 3});
        System.out.println(average2);
    }

}
