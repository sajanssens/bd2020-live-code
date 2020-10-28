package org.example.dao;

import org.example.domain.Employee;

import javax.persistence.EntityManager;

public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void save(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Employee get(long id) {
        return em.find(Employee.class, id);
    }

}
