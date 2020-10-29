package org.example.dao;

import org.example.domain.Employee;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeDaoIT {

    private EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private EmployeeDao target = new EmployeeDao(em);

    @Test
    void whenEmployeeIsSavedAndGottenThenIsHasAnId() {
        target.save(new Employee("ABC"));
        Employee employee = target.get(1);

        assertThat(employee.getId()).isEqualTo(1);
    }

    @Test
    void whenEmployeeIsGottenResumeIsLazyLoaded() {
        Employee e = new Employee("emp");
        e.setResume("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent non tempus enim. Duis eget sapien enim. Morbi elementum dictum tempus. Sed posuere tortor mauris, quis vehicula tellus congue non.");
        target.save(e);

        Employee employee = target.get(e.getId());
        String resume = employee.getResume();
        assertThat(resume).isBlank();
    }
}
