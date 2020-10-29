package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
public class Employee { // POJO (plain old java object)

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Employee() { }

    public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
