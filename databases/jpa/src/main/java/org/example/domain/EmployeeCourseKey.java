package org.example.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeCourseKey implements Serializable {

    // @Column(name = "employeeId")
    private long eId;
    // @Column(name = "courseId")
    private long cId;

    public EmployeeCourseKey() { }

    public EmployeeCourseKey(long eId, long cId) {
        this.eId = eId;
        this.cId = cId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeCourseKey that = (EmployeeCourseKey) o;
        return Objects.equals(eId, that.eId) &&
                Objects.equals(cId, that.cId);
    }

    @Override public int hashCode() {
        return Objects.hash(eId, cId);
    }
}
