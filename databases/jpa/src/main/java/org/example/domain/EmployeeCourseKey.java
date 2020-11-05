package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeCourseKey implements Serializable {

    // @Column(name = "employeeId")
    private long employeeId;
    // @Column(name = "courseId")
    private long courseId;

    public EmployeeCourseKey() { }

    public EmployeeCourseKey(long employeeId, long courseId) {
        this.employeeId = employeeId;
        this.courseId = courseId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeCourseKey that = (EmployeeCourseKey) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override public int hashCode() {
        return Objects.hash(employeeId, courseId);
    }
}
