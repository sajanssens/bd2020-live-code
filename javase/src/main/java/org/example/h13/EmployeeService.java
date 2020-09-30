package org.example.h13;

import org.example.h10.Employee;

public class EmployeeService {

    public <T extends Employee> int leeftijdCalculator(T e) {
        int age = e.getAge();
        return age + 1;
    }

}
