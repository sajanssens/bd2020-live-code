package org.example.h6;

public class Getallen {

    private int[] getallen = new int[10];
    private int index = 0;

    public void voegToe(int eenGetal) {
        if (index < getallen.length) {
            getallen[index] = eenGetal;
            index++;
        }
    }

    public void printAlles() {
        for (int getal : getallen) {
            System.out.println(getal);
        }
    }

}
