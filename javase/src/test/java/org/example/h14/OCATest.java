package org.example.h14;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OCATest {

    private OCA target;

    @Before
    public void beforeEach() throws Exception {
        target = new OCA();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test1() {
        // given
        // see beforeEach

        // when
        target.question1();

        // then
        // assert: see @Test(expected..)
    }

    @Test
    public void test2a() {
        // given

        // when
        String result = target.question2(14);

        // then
        assertThat(result, is("Stand"));
    }

    @Test
    public void test2b() {
        // given

        // when
        String result = target.question2(18);

        // then
        assertThat(result, is("Stand"));
    }

}
