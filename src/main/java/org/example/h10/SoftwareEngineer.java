package org.example.h10;

public class SoftwareEngineer extends PermanentEmployee implements Promotable {

    private String favoriteLanguage;

    public SoftwareEngineer(int id, int pos, String favoriteLanguage) {
        super(id, pos);
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override // != Overloading!
    public long getSalary() {
        return (long) (super.getSalary() * 1.1);
    }

    public static void print() {
        System.out.println("Ik ben programmeur in vaste dienst.");
    }

    public void promote(){
        System.out.println("Yeah, I got promoted!");
    }

}
