package org.pubs;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pubs").createEntityManager();

    }
}
