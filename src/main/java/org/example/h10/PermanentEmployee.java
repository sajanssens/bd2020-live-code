package org.example.h10;

public class PermanentEmployee extends Employee {
    protected int position;


    public PermanentEmployee(int id, int position) {
        super(id);
        this.position = position;
    }

    public long getSalary() {
        return 2500 * position;
    }

}
