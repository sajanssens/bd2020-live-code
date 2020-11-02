package org.example.dao;

import org.example.domain.Department;
import org.example.domain.ParkingSpace;

import javax.persistence.EntityManager;

public class DepartmentDao extends Dao<Department, Long> {
    public DepartmentDao(EntityManager em) {
        super(em);
    }
}
