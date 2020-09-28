package org.example.h14;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    public void test5() {
        // given
        // mock Scanner:
        ConsoleReader scannerMock = mock(ConsoleReader.class);
        target.setConsoleReader(scannerMock);
        when(scannerMock.read()).thenReturn("Pen", "Pencil", "Box");

        // mock System.out:
        ConsoleWriter soutMock = mock(ConsoleWriter.class);
        target.setConsoleWriter(soutMock);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        doNothing().when(soutMock).write(arg.capture());

        // when
        target.question5();

        // then
        verify(soutMock, times(1)).write(anyString());
        verify(soutMock, times(1)).write();

        List<String> allValues = arg.getAllValues();
        assertThat(allValues.size(), is(1));
        assertThat(allValues.get(0).trim(), is("Box"));
    }
}
