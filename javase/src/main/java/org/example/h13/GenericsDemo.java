package org.example.h13;

import org.example.h10.Employee;
import org.example.h10.Staff;
import org.example.h10.TemporaryEmployee;
import org.example.h7.Person;

import java.util.ArrayList;

public class GenericsDemo {

    // generics = generic types

    public static void main(String[] args) {

        Integer[] integers = new Integer[10];
        integers[0] = Integer.valueOf(0);
        integers[1] = 1;

        ArrayList getallen = new ArrayList();
        // getallen.add(new GenericsDemo());
        getallen.add("");
        getallen.add(1);
        getallen.add(1);
        getallen.add(1);
        getallen.add(1);
        getallen.add(1);

        int som = 0;

        for (Object o : getallen) {
            if (o instanceof Integer) {
                int getal = (Integer) o;
                // som = som + getal;
                som += getal;
            }
        }

        Person p = new Person("", 1);

        ArrayList<Integer> getallen2 = new ArrayList<>(); // type inference; to infer = afleiden
        getallen2.add(1);
        getallen2.add(1);
        getallen2.add(1);
        getallen2.add(1);
        getallen2.add(1); // type safe

        som = 0;
        for (Integer integer : getallen2) {
            som += integer;
        }

        // DRY
        BakjeObject bakje = new BakjeObject("");
        BakjeInteger bakjeInteger = new BakjeInteger(1);
        BakjeString bakjeString = new BakjeString("S");

        // Bakje<String> stringBakje = new Bakje<String>("hallo");
        // Bakje<Integer> integerBakje = new Bakje<Integer>(123);
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(1, 1, 1);
        Bakje<Employee> employeeBakje = new Bakje<>(temporaryEmployee);
        Staff staff = new Staff(1, 1, 1);
        Bakje<Staff> staffBakje = new Bakje<>(staff);


        EmployeeService service = new EmployeeService();
        service.leeftijdCalculator(staff);
        service.leeftijdCalculator(temporaryEmployee);
    }

    public void doeIetsMet(BakjeObject b) {
        Object inhoud = b.getInhoud();

    }

    public void doeIetsMet(BakjeInteger b) {
        Integer inhoud = b.getInhoud();
        inhoud++;
    }

}
