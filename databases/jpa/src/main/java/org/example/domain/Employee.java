package org.example.domain;

import org.example.util.BooleanTFConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
public class Employee { // POJO (plain old java object)

    // Basic fields:

    @Id
    @GeneratedValue
    private long id;

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

    // single valued relationships

    @ManyToOne(cascade = CascadeType.MERGE) // uni directional
    private Department worksAt;

    @ManyToOne
    private ParkingSpace parkingSpace;

    // ------------ code:

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

    public void setWorksAt(Department worksAt) {
        this.worksAt = worksAt;
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
}
