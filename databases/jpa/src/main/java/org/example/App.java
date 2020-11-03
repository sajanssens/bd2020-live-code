package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL-jpademo").createEntityManager();

    public static void main(String[] args) {
        new MainMenu().start();
    }

}
