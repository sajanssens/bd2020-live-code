package org.example.boundary;

import org.example.domain.Employee;

import static java.lang.Long.parseLong;
import static org.example.App.empDao;
import static org.example.App.readLine;

public class RaadplegenMedewerkers implements Boundary {

    private String zoeknaam = null;

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle medewerkers: ");

            empDao.findBy(zoeknaam).forEach(x -> System.out.println("\t" + x));

            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Medewerker verwijderen]");
            System.out.println("(2) [Medewerker toevoegen]");
            System.out.println("(3) [Medewerker zoeken]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1":
                    remove(); break;
                case "2":
                    add(); break;
                case "3":
                    search(); break;
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

    private void add() {
        System.out.println("Toevoegen medewerker.");
        System.out.print("Naam: ");

        Employee e = new Employee(readLine());
        empDao.save(e);
        System.out.println("Medewerker toegevoegd!");
    }

    private void search() {
        System.out.println("Zoeken medewerker.");
        System.out.print("Naam: ");

        this.zoeknaam = readLine();
        System.out.println("Resultaten:");
    }
}
