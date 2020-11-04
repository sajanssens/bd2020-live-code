package org.example.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<E, I> { // E: type of entity; I: type of id of entity

    protected final EntityManager em;

    public Dao(EntityManager em) { this.em = em; }

    public E get(I id) {
        return em.find(E(), id);
    }

    public E getDetached(I id) {
        E e = get(id);
        em.detach(e);
        return e;
    }

    public void save(E e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void saveAndDetach(E e) {
        em.getTransaction().begin();
        em.persist(e);
        em.flush();
        em.detach(e);
        em.getTransaction().commit();
    }

    public E update(E e) {
        em.getTransaction().begin();
        E merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public void remove(E e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public boolean isManaged(E e) {
        return em.contains(e);
    }

    public List<E> findAll() {
        return em.createQuery("SELECT e FROM " + typeSimple() + " e ", E()).getResultList();
    }

    public List<E> findAllWithNamedQuery() {
        return em.createNamedQuery(typeSimple() + ".findAll", E()).getResultList();
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
