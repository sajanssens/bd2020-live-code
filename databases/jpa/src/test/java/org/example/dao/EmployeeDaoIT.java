package org.example.dao;

import org.example.domain.Employee;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeDaoIT {

    private final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private final EmployeeDao target = new EmployeeDao(em);

    @Test
    void whenEmployeeIsSavedAndGottenThenIsHasAnId() {
        target.save(new Employee("ABC"));
        Employee employee = target.get(1);

        assertThat(employee.getId()).isEqualTo(1);
    }

    // IMPORTANT: to let this succeed, build your project woth maven first so the hibernate-enhance-maven-plugin is executed!
    @Test
    void whenEmployeeIsLoadedResumeIsLazilyLoaded() {
        // given a new and saved employee
        Employee e = new Employee("emp");
        e.setResume("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent non tempus enim. Duis eget sapien enim. Morbi elementum dictum tempus. Sed posuere tortor mauris, quis vehicula tellus congue non.");
        target.saveAndDetach(e);

        // when we get it from the db and it is detached
        Employee detachedEmp = target.get(e.getId());
        em.clear(); // detach
        // then resume is not loaded and cannot be loaded anymore
        assertThat(target.isManaged(detachedEmp)).isFalse();
        assertThrows(LazyInitializationException.class, detachedEmp::getResume);

        // but
        // when we keep it managed
        Employee managedEmp = target.get(e.getId());
        // then the resume can be loaded
        assertThat(target.isManaged(managedEmp)).isTrue();
        String resume = managedEmp.getResume(); // get resume from managed employee
        assertThat(resume).isNotBlank(); // this should succeed
    }
}
