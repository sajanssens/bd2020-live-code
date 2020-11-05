package org.example.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Course extends AbstractEntity<Long> {

    @NonNull private String title;

    @OneToMany(mappedBy = "course")
    private Set<EmployeeCourse> employees = new HashSet<>();

    public void addEmployee(EmployeeCourse course) {
        this.employees.add(course);
    }
}
