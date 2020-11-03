package org.example;

import org.example.domain.Employee;

import static org.example.App.empDao;
import static org.example.App.readLine;

public class ToevoegenMedewerker {

    public void start() {
        System.out.println("Toevoegen medewerker.");
        System.out.print("Naam: ");

        Employee e = new Employee(readLine());
        empDao.save(e);
        System.out.println("Medewerker toegevoegd!");
    }

}
