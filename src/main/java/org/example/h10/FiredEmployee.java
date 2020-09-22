package org.example.h10;

public class FiredEmployee extends Employee {

    public FiredEmployee(int id) {
        super(id);
    }

    @Override
    public long getSalary() {
        return 0;
    }
}
