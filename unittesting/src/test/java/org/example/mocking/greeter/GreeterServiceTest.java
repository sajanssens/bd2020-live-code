package org.example.mocking.greeter;

import org.example.mocking.greeter.GreeterService;
import org.example.mocking.greeter.Person;
import org.example.mocking.greeter.PersonDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreeterServiceTest {

    @InjectMocks
    private GreeterService target;

    @Mock
    private PersonDao personDaoMock;

    @BeforeEach
    void setUp() {
        // given
        when(personDaoMock.get(anyInt())).thenReturn(new Person(0, "Ben Nep"));
    }

    @Test
    void greet() {
        // when
        String greet = target.greet();

        // then
        assertThat(greet, is("Hello Ben Nep"));
        verify(personDaoMock).get(anyInt());
    }
}
