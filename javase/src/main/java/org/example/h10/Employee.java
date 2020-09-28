package org.example.h10;

public abstract class Employee implements Comparable<Employee> {

    protected int id;
    private int age;

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public abstract long getSalary() /*{ return -1;}*/;

    public static void print() {
        System.out.println("Ik ben een employee.");
    }

    public void gewoneMethode() {

    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee other) {
        // this > other : return een positief getal (1, 100000, 847667, ...)
        // this < other : return een negatief getal (-1, -100000, -847667, ...)
        // this == other: return 0
        if (this.id < other.id) {
            return -1;
        } else if (this.id > other.id) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
