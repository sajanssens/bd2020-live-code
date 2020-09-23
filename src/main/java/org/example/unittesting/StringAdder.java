package org.example.unittesting;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {
        if (s.isEmpty()) {
            return ZERO;
        }

        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
