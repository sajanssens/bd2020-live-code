package org.example.h13;

import org.example.h10.Employee;

public class Bakje<T extends Employee> { // boundary

    private T inhoud;

    public Bakje() {
    }

    public Bakje(Class<T> aType) throws IllegalAccessException, InstantiationException {
        this.inhoud = aType.newInstance();
        // this.inhoud = new T();

        // T[] lijst = new T[4];
    }

    public Bakje(T inhoud) {
        this.inhoud = inhoud;
    }

    public T getInhoud() { return inhoud; }

    public void setInhoud(T inhoud) { this.inhoud = inhoud; }

}
