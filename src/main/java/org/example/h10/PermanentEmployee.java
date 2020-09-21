package org.example.h10;

public class PermanentEmployee extends Employee {
    protected int position;

    public PermanentEmployee() {
        // super();
    }

    public PermanentEmployee(int position) {
        // super();
        this.position = position;
    }

    public long getSalary() {
        return 2500 * position;
    }



}
