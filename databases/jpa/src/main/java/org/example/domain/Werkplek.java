package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Werkplek extends AbstractEntity {

    private String number;

    // collection valued (standaard lazy loading) bidi
    @JoinTable(name = "medewerkerwerkplek",
            joinColumns = @JoinColumn(name = "werkplekId"),
            inverseJoinColumns = @JoinColumn(name = "medewerkerId"))
    @ManyToMany/*(mappedBy = "flexwerkplek")*/
    private List<Employee> users = new LinkedList<>();

    public Werkplek() {

    }

    public Werkplek(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String brand) {
        this.number = brand;
    }

    @Override public String toString() {
        return "Werkplek{" +
                "id=" + id +
                ", brand='" + number + '\'' +
                '}';
    }
}
