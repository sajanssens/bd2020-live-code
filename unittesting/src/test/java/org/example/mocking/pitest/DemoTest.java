package org.example.mocking.pitest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {

    private final Demo demo = new Demo();

    @Test
    public void testGreatest() {
        int greatest = demo.greatest(40, 200);

        // assertEquals(greatest, 200); // JUnit5
        // assertThat(greatest, is(200)); // hamcrest
        assertThat(greatest).isEqualTo(200);// AssertJ
    }

    @Test
    public void testGreatest2() {
        int greatest = demo.greatest(400, 200);
        assertThat(greatest).isEqualTo(400);
    }

    @Test
    public void testGreatest3() {
        int greatest = demo.greatest(100, 100);
        assertThat(greatest).isEqualTo(100);
    }

}
