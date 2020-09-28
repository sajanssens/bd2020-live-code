package org.example.h10;

public class Staff extends PermanentEmployee implements Promotable {

    public Staff(int id, int age, int pos) {
        super(id, age, pos);
    }

    public static void print() {
        System.out.println("Ik ben staff in vaste dienst.");
    }

    @Override
    public void promote() {
        this.position++;
        System.out.println("Staff is promoted");
    }
}
