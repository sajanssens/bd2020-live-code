package org.example.boundary;

import static org.example.App.readLine;

public class MainMenu implements Boundary {

    public void start() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welkom bij het Medewerkers Management Systeem!");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Medewerkers] ");
            System.out.println("(x) [Afsluiten] ");

            try {
                switch (readLine()) {
                    case "1":
                        new RaadplegenMedewerkers().start(); break;
                    case "x":
                        System.out.println("Tot ziens."); return;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw."); break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (RuntimeException t) {
                System.out.println("Er ging iets mis... Probeer het opnieuw. ");
                System.out.println("Foutmelding: " + t.getMessage());
            } catch (Exception e) {
                System.out.println("Er ging iets vreselijk mis... ");
                System.out.println("Foutmelding: " + e.getMessage());
                System.out.println("Neem contact op met de leverancier.");
                System.out.println("Tot ziens.");
            }

        }

    }
}
