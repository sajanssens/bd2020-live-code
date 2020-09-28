package org.example.h10.drummodule;

public class Distortion implements Effect {

    @Override
    public void process(StringBuilder sound) {
        sound.append(" Roar!");
    }
}
