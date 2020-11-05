package org.example.dao;

import org.example.domain.Course;
import org.example.domain.EmployeeCourse;
import org.example.domain.EmployeeCourseKey;

import javax.persistence.EntityManager;

public class CourseDao extends Dao<Course, Long> {
    public CourseDao(EntityManager em) {
        super(em);
    }
}
