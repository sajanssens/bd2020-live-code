package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "Department.findAll", query = "select e from Department e")
public class Department extends AbstractEntity {

    private String name;

    public Department() {
    }

    // collection valued (standaard lazy loading)
    @OneToMany(mappedBy = "worksAt", fetch = FetchType.EAGER)
    private List<Employee> workers = new ArrayList<>();

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
