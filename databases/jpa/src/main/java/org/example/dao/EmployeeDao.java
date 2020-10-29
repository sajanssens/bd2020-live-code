package org.example.dao;

import org.example.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public void saveAndDetach(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        detach();
        em.getTransaction().commit();
    }

    private void detach() {
        em.flush();
        em.clear();
    }

    public Employee update(Employee e) {
        em.getTransaction().begin();
        Employee merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
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

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ", Employee.class);
        return query.getResultList();
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

    public List<Employee> findAllWithNamedQuery() {
        TypedQuery<Employee> findAll = em.createNamedQuery("Employee.findAll", Employee.class);
        return findAll.getResultList();
    }

    public void remove(long id) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
    }

    public void remove(Employee e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
