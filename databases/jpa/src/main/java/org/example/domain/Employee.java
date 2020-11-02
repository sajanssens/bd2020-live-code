package org.example.domain;

import org.example.util.BooleanTFConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends AbstractEntity { // POJO (plain old java object)

    // Basic fields:

    // @Basic
    private String name;

    @Temporal(value = DATE)
    private Date birthday = new Date();

    // Better: use LocalDate or LocalDateTime
    // Will be converted (automatically) to time by LocalDateTimeAttributeConverter
    // @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime timeOfBirth = LocalDateTime.of(1979, 8, 22, 6, 15, 23, 789); // 22-08-1979 06h:15m

    @Convert(converter = BooleanTFConverter.class)
    private Boolean hasDriversLicence = false;

    @Enumerated(value = EnumType.STRING)
    private Gender gender = Gender.MALE;

    @Embedded
    private Address addressWork;

    @Lob // CLOB Character large object
    @Basic(fetch = LAZY) // only loaded when explicitly called (with getResume()) on a managed object.
    private String resume;

    @Lob // BLOB Binary large object
    @Basic(fetch = EAGER)
    private byte[] image;

    // ---- relations:

    // single valued relationships (standaard eager loading)

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // bi directional
    private Department worksAt;

    @ManyToOne(fetch = LAZY)
    private ParkingSpace parkingSpace; // bi directional, owning side

    @OneToOne(cascade = CascadeType.PERSIST)
    private Car leaseCar;

    // collection valued (standaard lazy loading) bidi
    @JoinTable(name = "medewerkerwerkplek",
            joinColumns = @JoinColumn(name = "medewerkerId"),
            inverseJoinColumns = @JoinColumn(name = "werkplekId"))
    @ManyToMany(/*mappedBy = "users", */cascade = CascadeType.PERSIST, fetch = LAZY)
    private List<Werkplek> flexwerkplekken = new LinkedList<>();

    // ------------ code:

    public Employee() { }

    public Employee(String name) {
        this.name = name;
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

    public void setWorksAt(Department worksAt) {
        this.worksAt = worksAt;
    }

    public void setLeaseCar(Car leaseCar) {
        this.leaseCar = leaseCar;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
        this.parkingSpace.addEmployee(this);
    }

    public void addFlexwerkplek(Werkplek w) {
        this.flexwerkplekken.add(w);
    }

    public List<Werkplek> getFlexwerkplekken() {
        return flexwerkplekken;
    }
}
