package org.example.h12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Start {

    public static void main(String[] args) {
        Class<AnnotationsDemo> consoleAppClass = AnnotationsDemo.class;

        // print class info:
        Annotation[] annotations = consoleAppClass.getAnnotations();
        System.out.println(consoleAppClass.getSimpleName() + " has annotations:");
        for (Annotation annotation : annotations) {
            System.out.println("\t" + annotation);
        }

        // print methods in class:
        System.out.println(consoleAppClass.getSimpleName() + " has methods:");
        Method[] declaredMethods = consoleAppClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.print("\t" + declaredMethod.getName());
            // print annotations on method
            System.out.println(" with annotations:");
            Annotation[] declaredAnnotations = declaredMethod.getAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println("\t\t" + declaredAnnotation.toString());
            }
        }

    }
}
