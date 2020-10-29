package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }
}
