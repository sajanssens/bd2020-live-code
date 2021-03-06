package org.pubs.dao;

public class Tuple<T, V, W> {
    public final T a;
    public final V b;
    public final W c;

    public Tuple(T a, V b, W c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override public String toString() {
        return "Tuple2{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
