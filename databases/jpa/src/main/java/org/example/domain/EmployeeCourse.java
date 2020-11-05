package org.example.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import static javax.persistence.CascadeType.ALL;

@Entity
public class EmployeeCourse {

    @EmbeddedId
    private EmployeeCourseKey id;

    @ManyToOne(cascade = ALL)
    @MapsId("employeeId") // field van EmployeeCourseKey; soort mappedBy voor composite key?
    // @JoinColumn(name = "employeeId") // hoe willen we de column noemen?
    private Employee employee;

    @ManyToOne(cascade = ALL)
    @MapsId("courseId")
    // @JoinColumn(name = "courseId")
    private Course course;

    private int rating;

    public EmployeeCourse() { }

    public EmployeeCourse(Employee e, Course c) {
        this.id = new EmployeeCourseKey(e.id, c.id);
        this.employee = e;
        this.course = c;
        e.addCourse(this);
        c.addEmployee(this);
    }

    public void setRating(int rating) { this.rating = rating; }

}
