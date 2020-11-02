package org.pubs.dao;

import org.example.dao.Dao;
import org.pubs.domain.Publisher;

import javax.persistence.EntityManager;

public class PublisherDao extends Dao<Publisher, String> {
    public PublisherDao(EntityManager em) {
        super(em);
    }
}
