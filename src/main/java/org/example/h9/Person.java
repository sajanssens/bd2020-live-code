package org.example.h9;

public class Person {

    private String firstname;
    private String lastname;
    private int age;


    private Person() {
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    static class PersonBuilder {

        private final Person p;

        public PersonBuilder() {
            p = new Person();
        }

        public PersonBuilder firstname(String s) {
            p.firstname = s;
            return this;
        }

        public PersonBuilder lastname(String s) {
            p.setLastname(s);
            return this;
        }

        public PersonBuilder age(int a) {
            p.setAge(a);
            return this;
        }

        public Person build() {
            return this.p;
        }
    }

}



