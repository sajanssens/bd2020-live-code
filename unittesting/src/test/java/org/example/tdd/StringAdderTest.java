package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAdderTest {

    @Test
    public void whenAddIsCalledWithEmptyStringItReturnsZero() {
        StringAdder adder = new StringAdder();
        int result = adder.add("");
        assertThat(result, is(0));
    }

    @Test
    public void whenAddIsCalledWithOneItReturnsOne() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1");
        assertThat(result, is(1));
    }

    @Test
    public void whenAddIsCalledWithANumberItReturnsThatNumber() {
        StringAdder adder = new StringAdder();
        int result = adder.add("4");
        assertThat(result, is(4));
    }

    @Test
    public void whenAddIsCalledWithANumberAndSpacesItReturnsThatNumber() {
        StringAdder adder = new StringAdder();
        int result = adder.add("  56     ");
        assertThat(result, is(56));
    }

    @Test
    public void whenAddIsCalledWithAVeryLargeNumberItThrowsAnException() {
        StringAdder adder = new StringAdder();
        assertThrows(IllegalArgumentException.class, () -> adder.add("8734628746238476238476"));
    }

    @Test
    public void whenAddIsCalledWithAnInvalidInputItThrowsAnExceptionWithTheCorrectMessage() {
        StringAdder adder = new StringAdder();
        IllegalArgumentException a =
                assertThrows(IllegalArgumentException.class, () -> adder.add("a"));
        assertThat(a.getMessage(), containsString("een getal"));

        a = assertThrows(IllegalArgumentException.class, () -> adder.add("twee"));
        assertThat(a.getMessage(), containsString("een getal"));
    }

    @Test
    public void whenAddIsCalledWithTwoNumbersSeparatedByACommaItReturnsTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("4,5");
        assertThat(result, is(9));

        result = adder.add("4, 5");
        assertThat(result, is(9));

        result = adder.add("4 , 5");
        assertThat(result, is(9));

        result = adder.add("   4 , 5    ");
        assertThat(result, is(9));
    }

    @Test
    public void whenAddIsCalledWithTwoNumbersNotSeparatedByCommaItThrowsAnException() {
        StringAdder adder = new StringAdder();
        assertThrows(IllegalArgumentException.class, () -> adder.add("4 6"));
        assertThrows(IllegalArgumentException.class, () -> adder.add("1-1"));
    }

    @Test
    public void whenAddIsCalledWithOneNumberAndACommaItReturnsThatNumber() {
        StringAdder adder = new StringAdder();
        int result = adder.add(",-5");
        assertThat(result, is(-5));

        result = adder.add("-5,");
        assertThat(result, is(-5));

        result = adder.add("   3  , ");
        assertThat(result, is(3));
    }

    @Test
    public void whenAddIsCalledWithTwoNumbersWhichCanBeNegativeAndSeparatedByACommaItReturnsTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("-4,-5");
        assertThat(result, is(-9));

        result = adder.add("-4,5");
        assertThat(result, is(1));
    }

    @Test
    public void whenAddIsCalledWithNumbersSeparatedByACommaItReturnsTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("4,5,6");
        assertThat(result, is(15));
    }

    @Test
    public void whenAddIsCalledWithPossiblyEmptyNumbersSeparatedByACommaItReturnsTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add(" ,   4, ,6, ");
        assertThat(result, is(10));

        result = adder.add(",  , ,,   ");
        assertThat(result, is(0));
    }

}
