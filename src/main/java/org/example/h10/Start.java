package org.example.h10;

public class Start {

    public static void main(String[] args) {
        Employee employee;

        employee = new PermanentEmployee(1, 1);  // mag want PE is een E
        System.out.println(employee.getSalary());

        employee = new TemporaryEmployee(1, 40);  // mag want TE is een E
        System.out.println(employee.getSalary());

        SoftwareEngineer bram = new SoftwareEngineer(1, 2, "Java");
        employee = bram;

        employee.print();
        bram.print();

        HR hr = new HR();

        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(4, 20);

        hr.promote(bram);
        hr.promote(temporaryEmployee);

        Promotable[] promotables = {bram, temporaryEmployee, new Robot(), new Staff(1, 1)};
        hr.promote(promotables);

        try (Robot r = new Robot()) {
            r.promote();
        }
    }
}
