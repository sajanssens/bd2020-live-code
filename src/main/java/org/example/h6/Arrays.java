package org.example.h6;

import org.example.h7.Person;

public class Arrays {

    public static void main(String[] args) {
        Getallen g = new Getallen();
        g.voegToe(9);
        g.voegToe(3);
        g.voegToe(2);

        // g.printAlles();

        int i = 0;

        int[] lijst = new int[10];
        for (int elem : lijst) {
            System.out.println(elem);
        }

        int lengte = 10;

        Person[] personen = new Person[lengte];
        for (Person person : personen) {
            System.out.println(person);
        }

        int[][] tabel = {{1, 2, 3}, {2, 2, 3}, {3, 2, 3}};
        int[] ints = tabel[0];
        int anInt = ints[1];
        // int anInt1 = ints[3];
        int waarde = tabel[1][2];

        for (int[] rij : tabel) {
            for (int cel : rij) {
                System.out.println(cel);
            }
        }

        print(ints);
        print(new int[]{1, 2, 3, 4, 5});

        int length = ints.length;

        // null = 32/64 bits

        int cijfer = 0;
        cijfer += 3; // c = c + 3;
        cijfer *= 10; // c = c * 10;

    }

    public static void print(int[] rijtje) {
        for (int i : rijtje) {
            System.out.println(i);
        }
    }

}
