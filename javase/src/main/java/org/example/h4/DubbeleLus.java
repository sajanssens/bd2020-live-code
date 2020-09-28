package org.example.h4;

public class DubbeleLus {

    public static void voerUit() {
        int rij = 1;
        while (rij <= 4) {
            int kolom = 1;
            while (kolom <= 6) {
                int hoogte = 1;
                while (hoogte <= 5) {
                    System.out.println("(" + rij + "," + kolom + "," + hoogte + ")");
                    hoogte++;
                }
                kolom++;
            }
            rij++;
        }

    }

}
