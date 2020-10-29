package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingSpace {

    @Id
    @GeneratedValue
    private long id;

    private int number;

    public ParkingSpace() { }

    public ParkingSpace(int number) {
        this.number = number;
    }

    // collection valued relationships

    @OneToMany(mappedBy = "parkingSpace") // lazy loaded by default
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        // employee.setParkingSpace(this);
    }
}
