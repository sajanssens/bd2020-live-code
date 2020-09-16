package org.example.h5;

public class Calculator {

    public int addOne(int x) {
        ++x;
        return x;
    }

    public void addOne(Getal x) {
        x.inhoud++;
    }

    public void addOne(Integer i) {
        i++;
    }

    public void addOne(String s) {
        s = s + "1";
        System.out.println(s);
    }

    public double average(int... values) {
        float sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public void printAflopendeRij(int startwaarde) {
        for (int i = startwaarde; i > 0; i--) {
            System.out.println(i);
        }
    }

    public void printAflopendeRijRecursief(int startwaarde) {
        System.out.println(startwaarde); // altijd printen
        if (startwaarde > 0) { // als er nog stappen te gaan zijn: volgende printen m.b.v. mezelf
            printAflopendeRijRecursief(startwaarde - 1);
        }
    }

    public int som(int n) {
        if (n <= 1) { // stopconditie
            return n;
        }
        return n + som(n - 1); // recursie
    }

}
