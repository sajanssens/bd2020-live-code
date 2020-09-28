package org.example.mocking.greeter;

public class PersonDao {

    public Person get(int id) {
        // ga naar de database en haal een person op...
        return new Person(id, "Janssens");
    }

}
