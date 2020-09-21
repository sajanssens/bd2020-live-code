package org.example.h7;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PersonTest {

    private Person p;

    @Before
    public void setUp() {
        p = new Person("de Jonge");
    }

    @Test
    public void givenAPersonWhenWeGetTheLaptopItCanBeNull() {
        Laptop mijnLaptop = p.getMijnLaptop();
        assertThat(mijnLaptop, is(nullValue()));
    }
}
