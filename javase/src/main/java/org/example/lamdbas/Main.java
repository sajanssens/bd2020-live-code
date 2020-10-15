package org.example.lamdbas;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        BiFunction<Integer, Integer, Integer> optellen = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> aftrekken = (a, b) -> a - b;

        calculator.calculate(3, 4, optellen);
        calculator.calculate(3, 5, aftrekken);
        calculator.calculate(3, 4, (a, b) -> a / b);
    }

}
