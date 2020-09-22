package org.example.h10;

public abstract class Employee {

    private int id;

    public Employee(int id) {this.id = id;}

    public abstract long getSalary() /*{ return -1;}*/;

    public static void print() {
        System.out.println("Ik ben een employee.");
    }

    public void gewoneMethode() {

    }

}
