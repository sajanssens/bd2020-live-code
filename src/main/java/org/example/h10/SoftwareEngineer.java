package org.example.h10;

public class SoftwareEngineer extends PermanentEmployee implements Promotable {

    private String favoriteLanguage;

    public SoftwareEngineer(int id, int age, int pos, String favoriteLanguage) {
        super(id, age, pos);
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override // != Overloading!
    public long getSalary() {
        return (long) (super.getSalary() * 1.1);
    }

    public static void print() {
        System.out.println("Ik ben programmeur in vaste dienst.");
    }

    public void promote() {
        System.out.println("Yeah, I got promoted!");
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    // from object:

    @Override
    public String toString() {
        return "SoftwareEngineer: " + this.favoriteLanguage;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SoftwareEngineer)) {
            return false;
        }

        SoftwareEngineer other = (SoftwareEngineer) obj;

        if (this.id == other.id && this.favoriteLanguage.equals(other.favoriteLanguage)) {
            return true;
        }

        return false;
    }
}
