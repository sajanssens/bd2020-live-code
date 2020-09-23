package org.example.h9;

public class Start {

    public static void main(String[] args) {
        Person.PersonBuilder builder = new Person.PersonBuilder();

        Person p1 = builder.firstname("Bram").lastname("Janssens").age(41).build();
        Person p2 = builder.age(23).lastname("de Vries").build();

        Employee e = Employee.builder().achternaam("X").leeftijd(32).schoenmaat(34).gender(Gender.MALE).build();
        System.out.println(e);

        int schoenmaat = e.getSchoenmaat();
    }
}
