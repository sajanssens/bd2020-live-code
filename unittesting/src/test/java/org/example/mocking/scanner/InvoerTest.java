package org.example.mocking.scanner;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvoerTest {

    Invoer target = new Invoer();

    ScannerWrapper mock = mock(ScannerWrapper.class);

    @Test
    void testRun() {
        Invoer target = new Invoer();
        target.setScannerWrapper(mock);
        when(mock.read()).thenReturn("ABC");

        String run = target.run();
        assertThat(run, containsString("Lengte is:"));
    }
}
