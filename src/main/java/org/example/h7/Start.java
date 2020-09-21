package org.example.h7;

public class Start {

    public static void main(String[] args) {
        Person bram = new Person("Janssens");
        // bram.setLastName("Janssens");
        // bram.age = -1;
        // bram.setAge(-1);
        bram.setAge(41);
        bram.setShoeSize(43);
        Laptop dell = new Laptop("DELL");
        // bram.setMijnLaptop(dell);

        Person bas = new Person();
        bas.setAge(25);
        bas.setMijnLaptop(dell);

        Person bart = new Person();
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
