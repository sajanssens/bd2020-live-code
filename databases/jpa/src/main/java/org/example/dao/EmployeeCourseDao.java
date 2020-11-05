package org.example.dao;

import org.example.domain.EmployeeCourse;
import org.example.domain.EmployeeCourseKey;

import javax.persistence.EntityManager;

public class EmployeeCourseDao extends Dao<EmployeeCourse, EmployeeCourseKey> {
    public EmployeeCourseDao(EntityManager em) {
        super(em);
    }
}
