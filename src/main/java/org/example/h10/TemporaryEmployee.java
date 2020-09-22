package org.example.h10;

public class TemporaryEmployee extends Employee implements Promotable {
    private int numberOfHours;

    public TemporaryEmployee(int id, int numberOfHours) {
        super(id);
        this.numberOfHours = numberOfHours;
    }

    public long getSalary() {
        return numberOfHours * 40;
    }

    @Override
    public void promote() {
        System.out.println("Jippie!");
    }
}
