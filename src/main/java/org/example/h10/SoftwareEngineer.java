package org.example.h10;

public class SoftwareEngineer extends PermanentEmployee {

    private String favoriteLanguage;

    public SoftwareEngineer(int pos, String favoriteLanguage) {
        // super();
        super(pos);
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override // != Overloading!
    public long getSalary() {
        return (long) (super.getSalary() * 1.1);
    }

    public static void print() {
        System.out.println("Ik ben programmeur in vaste dienst.");
    }
}
