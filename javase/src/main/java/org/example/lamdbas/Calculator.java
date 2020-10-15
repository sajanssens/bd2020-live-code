package org.example.lamdbas;

import java.util.function.BiFunction;

public class Calculator {

    public int calculate(int a, int b, BiFunction<Integer, Integer, Integer> f) {
        return f.apply(a, b);
    }

}
