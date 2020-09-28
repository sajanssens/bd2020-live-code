package org.example.h8;

import org.example.h10.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Class<Employee> employeeClass = Employee.class;

        Method[] declaredMethods = employeeClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] declaredAnnotations = declaredMethod.getAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredMethod);
            }

        }

    }
}
