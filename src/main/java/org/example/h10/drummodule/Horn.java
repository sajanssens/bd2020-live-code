package org.example.h10.drummodule;

public class Horn implements Effect {
    @Override
    public void process(StringBuilder sound) {
        sound.append("TOET!");
    }
}
