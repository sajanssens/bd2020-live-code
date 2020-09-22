package org.example.h10;

public class Robot implements Promotable, AutoCloseable {
    @Override
    public void promote() {
        System.out.println("Bliep, yes!");
    }

    @Override
    public void close() {
        System.out.println("Shutting down....");
    }
}
