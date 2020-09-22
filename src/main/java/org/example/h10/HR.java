package org.example.h10;

public class HR {

    public void promote(Promotable p) {
        p.promote();
    }

    public void promote(Promotable[] ps) {
        for (Promotable p : ps) {
            p.promote();
        }
    }

}
