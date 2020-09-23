package org.example.h10;

public class FiredEmployee extends Employee {

    public FiredEmployee(int id, int age) {
        super(id, age);
    }

    @Override
    public long getSalary() {
        return 0;
    }
}
