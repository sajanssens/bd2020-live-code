package org.example.dao;

import org.example.domain.ParkingSpace;

import javax.persistence.EntityManager;

public class ParkingSpaceDao extends Dao<ParkingSpace> {
    public ParkingSpaceDao(EntityManager em) {
        super(em);
    }
}
