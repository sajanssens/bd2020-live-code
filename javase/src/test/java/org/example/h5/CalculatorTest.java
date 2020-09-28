package org.example.h5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testPrintAflopendeRij() {
        Calculator target = new Calculator();
        target.printAflopendeRij(10);
    }

    @Test
    public void testPrintAflopendeRijRecursief() {
        Calculator target = new Calculator();
        target.printAflopendeRijRecursief(10);
    }

    @Test
    public void testSom() {
        Calculator target = new Calculator();

        int som = target.som(10);
        assertEquals(55, som);

        som = target.som(0);
        assertEquals(0, som);

        som = target.som(-1);
        assertEquals(-1, som);
    }

    @Test
    public void testSomZero() {
        Calculator target = new Calculator();

        int som = target.som(0);
        assertEquals(0, som);

        som = target.som(-1);
        assertEquals(-1, som);
    }

    @Test
    public void testSomNegative() {
        Calculator target = new Calculator();

        int som = target.som(-1);
        assertEquals(-1, som);
    }
}
