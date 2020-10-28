package org.example;

import org.example.dao.EmployeeDao;
import org.example.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    private Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) { new App().run(); }

    private void run() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

        EmployeeDao dao = new EmployeeDao(em);
        Employee e = new Employee("Janssens");

        dao.save(e);

        Employee employee = dao.get(1);
        log.debug(employee.toString());
    }

}
