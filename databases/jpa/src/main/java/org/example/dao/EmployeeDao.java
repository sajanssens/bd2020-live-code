package org.example.dao;

import org.example.domain.Car;
import org.example.domain.Employee;
import org.example.domain.Werkplek;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class EmployeeDao extends Dao<Employee, Long> {

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

    public void addCar(Employee e, Car c) {
        e.setLeaseCar(c);
        update(e);
    }

    // JPQL Queries examples:

    public List<Employee> findBy(String name) {
        return isBlank(name) ? findAll() : findByName(name);
    }

    private List<Employee> findByName(String name) {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE UPPER(e.name) LIKE :firstarg", Employee.class);
        query.setParameter("firstarg", "%" + name.toUpperCase() + "%");
        return query.getResultList();
    }

    public List<Employee> findByDepartment(String depName) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e JOIN e.worksAt as d where d.name LIKE :firstarg", Employee.class);
        query.setParameter("firstarg", "%" + depName + "%");
        return query.getResultList();
    }

    public Employee findWithWerkplek(long id) {
        Employee e = em.find(Employee.class, id);
        List<Werkplek> flexwerkplekken = e.getFlexwerkplekken(); // and trigger JPA to load werkplekken
        return e;
    }

    public Employee findWithWerkplekWithQuery(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e JOIN FETCH e.flexwerkplekken as f where e.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Employee> findWithWerkplekken() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e JOIN FETCH e.flexwerkplekken as f", Employee.class);
        return query.getResultList();
    }

    // Native queries: pure sql
    @SuppressWarnings("unchecked")
    public List<Employee> findWithNative(String partOfResume) {
        Query nativeQuery = em.createNativeQuery("SELECT * FROM Employee WHERE resume LIKE :partOfResume", Employee.class);
        nativeQuery.setParameter("partOfResume", "'%" + partOfResume + "%'");
        return nativeQuery.getResultList();
    }

    // Criteria API ---------

    public List<Employee> findUsingCriteriaAPI(String name, Boolean hasDriversLicence) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);

        Root<Employee> emp = q.from(Employee.class);

        q.select(emp).distinct(true)
                .where(cb.or(
                        cb.equal(emp.get("name"), name),
                        cb.equal(emp.get("hasDriversLicence"), hasDriversLicence)
                        )
                );

        return em.createQuery(q).getResultList();
    }

}
