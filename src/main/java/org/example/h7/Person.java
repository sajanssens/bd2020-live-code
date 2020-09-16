package org.example.h7;

// De class
public class Person {

    // STATE -----------------------

    // attributes, fields, class variables, properties:
    private String lastName;
    private int age /*must be > 0*/;
    private int shoeSize;
    private double length;

    static final int MIN_AGE = 0;

    // ------------------------------

    // default ctor:
    public /*Person*/ Person() {
        // return new person
    }

    public Person(String name) {
        this.lastName = name;
    }

    public static boolean hasBirthday() {
        return true;
    }

    public double bmi(double weight) {
        return weight / (this.length * this.length);
    }

    // BEHAVIOUR ------------------
    // Methods
    public void fire() {
        System.out.println("You're fired: " + lastName);
    }

    public void haveBirthday() {
        this.age++;
    }

    // setters a.k.a. mutators:
    // public void set<fieldname>(<fieldtype> <identifier>){
    //      this.fieldname = identifier;
    // }

    public void setLastName(String newValue) {
        this.lastName = newValue;
    }

    public void setAge(int age) {
        if (age > MIN_AGE) {
            this.age = age;
        }
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // getters a.k.a. accessors
    // public <fieldtype> get<fieldname>(){
    //      return this.fieldname;
    // }
    public int getAge() {
        return this.age;
    }

    // ----------------------------

}
