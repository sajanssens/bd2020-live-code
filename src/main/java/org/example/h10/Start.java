package org.example.h10;

public class Start {

    public static void main(String[] args) {
        Employee employee;

        employee = new PermanentEmployee(1);  // mag want PE is een E
        System.out.println(employee.getSalary());

        employee = new TemporaryEmployee(40);  // mag want TE is een E
        System.out.println(employee.getSalary());

        employee = new SoftwareEngineer(2, "Java");

        Employee.print(); //
    }
}
