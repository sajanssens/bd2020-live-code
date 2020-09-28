package org.example.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreeterServiceTest {

    private GreeterService target;

    @BeforeEach
    void setUp() {
        target = new GreeterService();
    }

    @Test
    void greet() {
        PersonDao personDaoMock = mock(PersonDao.class); // new PersonDao(); maar dan een mock.
        when(personDaoMock.get(anyInt())).thenReturn(new Person(0, "Ben Nep"));
        target.setDao(personDaoMock);

        String greet = target.greet();

        assertThat(greet, is("Hello Ben Nep"));
    }
}
