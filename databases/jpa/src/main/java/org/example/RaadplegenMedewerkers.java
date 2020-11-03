package org.example;

import org.example.dao.EmployeeDao;
import org.example.domain.Employee;

import java.util.Scanner;

import static org.example.App.em;

public class RaadplegenMedewerkers {

    EmployeeDao dao = new EmployeeDao(em);

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle medewerkers: ");

            dao.findAll().forEach(x -> System.out.println("\t" + x));

            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Medewerker verwijderen]");
            System.out.println("(x) [Terug]");

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    remove(); break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void remove() {
        System.out.println("Welke medewerker wilt u verwijderen (geef een id)?");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Employee employee = dao.get(Long.parseLong(s));
        if (employee == null) {
            System.out.println("Medewerker " + s + " niet gevonden...");
            return;
        }

        dao.remove(employee);
        System.out.println("Medewerker " + s + " verwijderd.");
    }
}
