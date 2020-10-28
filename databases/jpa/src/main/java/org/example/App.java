package org.example;

import org.example.dao.EmployeeDao;
import org.example.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee e = new Employee("Janssens");

        dao.save(e);

        Employee employee = dao.get(1);
        log.debug(employee.toString());
    }

}
