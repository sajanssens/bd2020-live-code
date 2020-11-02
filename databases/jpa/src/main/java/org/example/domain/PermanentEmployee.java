package org.example.domain;

import javax.persistence.Entity;

@Entity
public class PermanentEmployee extends Employee {

    private int position;

    public PermanentEmployee() {

    }

    public PermanentEmployee(int position) {
        this.position = position;
    }

    public PermanentEmployee(String name, int position) {
        super(name);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override public String toString() {
        return "PermanentEmployee{" +
                "position=" + position +
                '}';
    }
}
