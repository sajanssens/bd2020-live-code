package org.example.h13.advanced;

public class BakjeGenericMulti<T> {
    T[] inhoud;

    public T[] getInhoud() { return inhoud; }

    public void setInhoud(T[] inhoud) { this.inhoud = (T[]) inhoud; }

    public T get(int index) { return inhoud[index]; }
}
