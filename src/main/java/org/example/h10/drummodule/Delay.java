package org.example.h10.drummodule;

public class Delay implements Effect {
    @Override
    public void process(StringBuilder sound) {
        if (sound.length() > 4) {
            sound.append(sound.substring(sound.length() - 4));
        }
    }
}
