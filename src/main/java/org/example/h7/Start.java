package org.example.h7;

public class Start {

    public static void main(String[] args) {
        Person bram = new Person("Janssens");
        Person bas = new Person();
        Person bart = new Person();

        // bram.setLastName("Janssens");
        // bram.age = -1;
        // bram.setAge(-1);
        bram.setAge(41);
        bram.setShoeSize(43);

        bas.setAge(25);

        bart.setLastName("van der Geest");

        bas.haveBirthday();
        System.out.println(bas.getAge());
        System.out.println(bram.getAge());

        bram.fire();
        bram.setLength(1.83);
        double bmi = bram.bmi(79.9);

        System.out.println("Dit is de minAge" + Person.MIN_AGE);
    }
}
