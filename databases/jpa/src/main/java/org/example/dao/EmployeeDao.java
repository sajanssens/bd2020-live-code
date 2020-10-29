package org.example.dao;

import org.example.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDao extends Dao<Employee> {

    public EmployeeDao(EntityManager em) {
        super(em);
    }

    public Employee updateName(long id, String name) {
        Employee e = this.get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setName(name);
            em.getTransaction().commit();
        }
        return e;
    }

    public List<Employee> findBy(String name) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.name LIKE :firstarg", Employee.class);
        query.setParameter("firstarg", "%" + name + "%");
        return query.getResultList();
    }

    public List<Employee> findByDepartment(String depName) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e JOIN e.worksAt as d where d.name LIKE :firstarg", Employee.class);
        query.setParameter("firstarg", "%" + depName + "%");
        return query.getResultList();
    }

    public void remove(long id) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
    }

}
