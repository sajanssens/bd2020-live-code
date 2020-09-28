package org.example.mocking;

public class GreeterService {

    private PersonDao dao = new PersonDao();

    public String greet() {
        Person person = dao.get(1);
        String name = person.getName();
        return "Hello " + name;
    }

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }
}
