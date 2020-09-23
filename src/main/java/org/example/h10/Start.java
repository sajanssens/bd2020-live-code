package org.example.h10;

import java.util.Arrays;

public class Start {

    public static void main(String[] args) {
        Employee employee;

        employee = new PermanentEmployee(1, 23, 1);  // mag want PE is een E
        System.out.println(employee.getSalary());

        employee = new TemporaryEmployee(1, 34, 40);  // mag want TE is een E
        System.out.println(employee.getSalary());

        SoftwareEngineer bram = new SoftwareEngineer(10, 56, 2, "Java");
        employee = bram;

        // employee.print();
        // bram.print();

        HR hr = new HR();

        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(4, 12, 20);

        hr.promote(bram);
        hr.promote(temporaryEmployee);

        Promotable[] promotables = {bram, temporaryEmployee, new Robot(), new Staff(1, 78, 1)};
        hr.promote(promotables);

        try (Robot r = new Robot()) {
            r.promote();
        }

        Employee[] employees = {bram, temporaryEmployee, new Staff(9, 45, 8)};  // 10,4,9
        System.out.println(Arrays.toString(employees));

        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));

        Object o = new SoftwareEngineer(6, 34, 6, "PHP");
        doeIets(o);
        doeIets(temporaryEmployee);

        SoftwareEngineer piet = new SoftwareEngineer(10, 56, 2, "Java");
        SoftwareEngineer arie = new SoftwareEngineer(10, 56, 2, "Java");
        // primitives met ==
        // objects met o1.equals(o2)

        // if (piet == arie) {
        if (piet.equals(arie)) {
            System.out.println("JA");
        } else {
            System.out.println("NEE");
        }

        // Arrays.sort(employees, new Comparator<Employee>() {
        //     @Override
        //     public int compare(Employee o1, Employee o2) {
        //         return o2.getAge() - o1.getAge();
        //     }
        // });
        //
        // Arrays.sort(employees, (o1, o2) -> o2.getAge() - o1.getAge()); // lambda
        //
        // for (Employee employee1 : employees) {
        //     System.out.println(employee1.getAge());
        // }
    }

    public static void doeIets(Object o) {
        if (o instanceof SoftwareEngineer) {
            SoftwareEngineer se = (SoftwareEngineer) o;
            System.out.println("Het is engineer met language: " + se.getFavoriteLanguage());
        }
    }
}
