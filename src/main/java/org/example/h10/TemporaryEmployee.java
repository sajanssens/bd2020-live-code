package org.example.h10;

public class TemporaryEmployee extends Employee{
    private int numberOfHours;

    public TemporaryEmployee(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public long getSalary() {
        return numberOfHours * 40;
    }
}
