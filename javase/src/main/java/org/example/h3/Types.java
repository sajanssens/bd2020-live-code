package org.example.h3;

public class Types {

    public void doeIets() {

        char letter = 'a'; // literal
        boolean isDitWaar = false; // boolean literal
        System.out.println((char) (letter - 26));

        int a = 8;
        int b = 8;

        int c = a + b;

        float pi_f = 3.14f;

        byte bb = 0b0110_0111;

        long lang = 100L;

        double pi = 3.14;

        isDit97(letter);

        Integer refTypeInt = new Integer(8);
    }

    void isDit97(char letter) {
        if (letter >= 97) {
            System.out.println("Het is waar!");
        }
    }

    public void testBoolean() {
        boolean executeTest = false;
        boolean fiveLowerThanOne = (5 < 1);

        executeTest = true;

        System.out.println(fiveLowerThanOne);
    }

}
