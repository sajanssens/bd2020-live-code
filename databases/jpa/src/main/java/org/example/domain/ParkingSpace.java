package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingSpace extends AbstractEntity {

    private int number;

    public ParkingSpace() { }

    public ParkingSpace(int number) {
        this.number = number;
    }

    // collection valued relationships

    @OneToMany(mappedBy = "parkingSpace") // bi directional, passive side
    private List<Employee> employees = new ArrayList<>(); // lazy loaded by default

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        // employee.setParkingSpace(this);
    }
}
