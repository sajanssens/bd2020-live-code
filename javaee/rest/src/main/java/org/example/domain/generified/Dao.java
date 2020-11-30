package org.example.domain.generified;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class Dao<E> {

    @PersistenceContext // Container managed persistence context
    private EntityManager em;

    public Collection<E> getAll() {
        return em.createNamedQuery(typeSimple() + ".findAll", E()).getResultList();
    }

    public E getById(String id) { return null; }

    public Collection<E> get(String q) {
        return null;
    }

    public boolean add(E c) {
        em.persist(c);
        return true; // Fix me ...
    }

    public boolean remove(String id) {
        return false;
    }

    public boolean update(String id, E c) {
        return false;
    }

    private String typeSimple() { return E().getSimpleName(); }

    /**
     * @return a class instance of the first generic type parameter (E) of this Dao,
     * e.g. for EmployeeDao<Employee, Long>, it returns Employee.class.
     */
    @SuppressWarnings("unchecked")
    private Class<E> E() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) thisDaoClass.getActualTypeArguments()[0];
    }
}

