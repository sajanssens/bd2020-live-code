package org.example.h7;

// De class
public class Person {

    // STATE -----------------------

    // attributes, fields, class variables, properties:
    private String lastName;
    private int age /*must be > 0*/;
    private int shoeSize;
    private double length;

    private Laptop mijnLaptop;

    static final int MIN_AGE = 0;

    // ------------------------------

    // default ctor:
    public Person() {
        this("onbekend");
    }

    public Person(String name) {
        this(name, -1);
    }

    public Person(String name, int age) {
        this(name, age, -100);
    }

    public Person(String name, int age, int shoeSize) {
        setLastName(name);
        setAge(age);
        setShoeSize(shoeSize);
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

    public void setMijnLaptop(Laptop mijnLaptop) {
        this.mijnLaptop = mijnLaptop;
    }

    // getters a.k.a. accessors
    // public <fieldtype> get<fieldname>(){
    //      return this.fieldname;
    // }
    public int getAge() {
        return this.age;
    }

    public Laptop getMijnLaptop() {
        return mijnLaptop;
    }

    // ----------------------------

}
