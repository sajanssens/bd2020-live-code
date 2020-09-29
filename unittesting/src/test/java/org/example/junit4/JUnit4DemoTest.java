package org.example.junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnit4DemoTest {

    @Test
    public void doeIets() {
        JUnit4Demo jUnit4Demo = new JUnit4Demo();
        String s = jUnit4Demo.doeIets();
        assertEquals(s, "iets");
    }
}
