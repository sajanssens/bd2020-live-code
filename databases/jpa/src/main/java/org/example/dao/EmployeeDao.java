package org.example.dao;

import org.example.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeeDao {
    EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public void save(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Employee get(long id) {
        return em.find(Employee.class, 1L);
    }

}
