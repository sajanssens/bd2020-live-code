package org.example.unittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAdderTest {

    @Test
    public void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
        StringAdder adder = new StringAdder();
        int result = adder.add("");
        assertEquals(0, result);
    }

    @Test
    public void whenAddIsCalledWithOneItShouldReturnOne() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1");
        assertEquals(1, result);
    }

}
