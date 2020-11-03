package org.example;

import org.example.domain.Employee;

import static java.lang.Long.parseLong;
import static org.example.App.empDao;
import static org.example.App.readLine;

public class RaadplegenMedewerkers {

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle medewerkers: ");

            empDao.findAll().forEach(x -> System.out.println("\t" + x));

            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Medewerker verwijderen]");
            System.out.println("(2) [Medewerker toevoegen]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1":
                    remove(); break;
                case "2":
                    new ToevoegenMedewerker().start(); break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void remove() {
        System.out.println("Welke medewerker wilt u verwijderen?");
        System.out.print("Id: ");

        String id = readLine();
        Employee employee = empDao.get(parseLong(id));
        if (employee == null) {
            System.out.println("Medewerker " + id + " niet gevonden...");
            return;
        }

        empDao.remove(employee);
        System.out.println("Medewerker " + id + " verwijderd.");
    }
}
