package org.example.domain;

import javax.persistence.Entity;

@Entity
public class TemporaryEmployee extends Employee {

    private int numberOfHours;

    public TemporaryEmployee() {
    }

    public TemporaryEmployee(String name, int numberOfHours) {
        super(name);
        this.numberOfHours = numberOfHours;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override public String toString() {
        return "TemporaryEmployee{" +
                "numberOfHours=" + numberOfHours +
                '}';
    }
}
