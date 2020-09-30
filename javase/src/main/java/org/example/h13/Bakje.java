package org.example.h13;

import org.example.h10.Employee;

public class Bakje<T extends Employee> { // boundary

    private T inhoud;

    public Bakje(T inhoud) {
        this.inhoud = inhoud;
    }

    public T getInhoud() { return inhoud; }

    public void setInhoud(T inhoud) { this.inhoud = inhoud; }

}
