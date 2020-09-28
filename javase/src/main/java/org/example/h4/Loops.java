package org.example.h4;

public class Loops {

    static void demoOperators() {
        int i = 13 / 4; // = 3
        int j = 13 % 4;
        System.out.println(j);

        int x;
        x = i++; // expression
        // x = i;
        // i = i + 1;
        System.out.println("A: " + x); // = 3
        // i = 4

        x = ++i;
        // i = i + 1;
        // x = i;
        System.out.println("B: " + x); // = 5

        System.out.println("C: " + i); // = 5

        byte b = 0b0000_0001;
        int shift = b << 1;
        // 0000_0010
        System.out.println(shift);
        shift = shift << 1;
        System.out.println(shift);
        shift = shift << 4;
        System.out.println(shift);

        if (i > 9 || i < 20) { // OR
            System.out.println("JA!");
        }

        String res = (i > 10) ? "Groter!" : "Kleiner!";
        System.out.println(res);
    }

    public static void loopsDemo() {
        // int i = 0; // 1
        // while (i < 10) { // 2
        //     System.out.println(i); // body...
        //     i++; // 3
        // }

        // int k = 0;
        // do {
        //     System.out.println(k);
        //     k++;
        // } while (k < 10);

        // voor j van 10 tot 0, met stapgrootte 2, doe:
        // for (int j = 10; j > 0; j = j - 2) {
        //     System.out.println(i);
        // }

        // for (; ; ) {System.out.println("Hello");}

        // int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -2};

        // for (int j = 0; j < values.length; j++) {
        //     if(values[j] > 5){
        //         // break;
        //         continue;
        //     }
        //     System.out.println(values[j]);
        // }

        // voor elke value in values, doe:
        // for (int value : values) {
        //     System.out.println(value);
        // }       

    }

}
