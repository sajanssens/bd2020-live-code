package org.example.h10.drummodule;

public class Phaser implements Effect {

    @Override
    public void process(StringBuilder sound) {
        String substring = sound.substring(sound.length() - 4).toUpperCase();

        sound.append("<phase>" + substring + "</phase>");
    }
}
