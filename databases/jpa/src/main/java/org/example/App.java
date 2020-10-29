package org.example;

import org.example.dao.Dao;
import org.example.dao.EmployeeDao;
import org.example.domain.Department;
import org.example.domain.Employee;
import org.example.domain.ParkingSpace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    private final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) { new App().run(); }

    private void run() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL-jpademo").createEntityManager();
        EmployeeDao dao = new EmployeeDao(em);

        // INSERT INTO ...
        Employee e = new Employee("Janssens");
        dao.save(e);

        // SELECT .. WHERE id = ...
        Employee e1 = dao.get(e.getId());
        log(e1);

        // Update with merge
        e1.setName("Hendriksen");
        dao.update(e1);

        // Update without merge:
        Employee e2 = new Employee("Pietersen");
        dao.save(e2);
        log("em.contains(e2): " + em.contains(e2)); // zit e2 nog in de persistence context?
        // e2.setName("Klaassen");
        // dao.save(e2);
        dao.updateName(e2.getId(), "Klaassen");

        // Save detached entity:
        Employee e3 = new Employee("Pietersen");
        dao.save(e3);

        dao.saveAndDetach(e3);
        log("em.contains(e3): " + em.contains(e3)); // zit e3 nog in de persistence context?

        e3.setName("Detached");
        // dao.save(e3); // not working

        // Employee e3Hot = dao.get(e3.getId()); // works; do a find first
        // dao.save(e3Hot);
        e3 = dao.update(e3); // merge works too! first, merges detached object into persistence context (i.e. find), then executes update query

        // remove
        // dao.remove(e3.getId()); // works for detached also
        dao.remove(e3); // e3 must be managed

        // find
        dao.findAll().forEach(emp -> log(emp));
        dao.findBy("Klaass").forEach(this::log); // with method reference (same as above)
        dao.findAllWithNamedQuery().forEach(this::log);

        // --------------

        e1.setWorksAt(new Department("Kenniscentrum"));
        dao.update(e1);

        Department software_development = new Department("Software development");

        Dao<Department> depDao = new Dao<>(em);
        depDao.save(software_development);

        e1.setWorksAt(software_development);
        dao.update(e1);

        e2.setWorksAt(software_development);
        dao.update(e2);

        List<Employee> soft = dao.findByDepartment("Softwa");
        soft.forEach(this::log);

        Dao<ParkingSpace> psDao = new Dao<>(em);

        ParkingSpace parkingSpace = new ParkingSpace(123);
        psDao.save(parkingSpace);

        e1.setParkingSpace(parkingSpace);
        e2.setParkingSpace(parkingSpace);

        dao.update(e1);
        dao.update(e2);

        parkingSpace.getEmployees().forEach(this::log);

        // em: persist, find, merge, remove, createQuery, createNamedQuery
    }

    private void log(Object o) {
        log.debug(o.toString());
    }

}
