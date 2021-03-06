package org.example.mocking.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ConsoleAppTest {

    private ConsoleApp target;

    @BeforeEach
    public void beforeEach() {
        target = new ConsoleApp();
    }

    @Test
    public void testRun() {
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
        target.run();

        // then
        List<String> allValues = arg.getAllValues();
        assertThat(allValues.size(), is(2));
        assertThat(allValues.get(0).trim(), is("Box"));
        assertThat(allValues.get(1).trim(), is(""));

        verify(scannerMock, times(3)).read();
        verify(soutMock, times(2)).write(anyString());
    }

}
