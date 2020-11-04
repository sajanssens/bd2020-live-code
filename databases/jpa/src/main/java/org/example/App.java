package org.example;

import org.example.boundary.MainMenu;
import org.example.dao.EmployeeDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL-jpademo").createEntityManager();
    public static final EmployeeDao empDao = new EmployeeDao(em);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { new MainMenu().start(); }

    public static String readLine() { return scanner.nextLine(); }
}
