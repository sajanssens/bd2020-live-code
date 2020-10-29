package org.example.dao;

import org.example.domain.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock
    private EntityManager emMock/* = Mockito.mock(EntityManager.class)*/;

    @InjectMocks
    private EmployeeDao target/* = new EmployeeDao(emMock)*/;

    @Mock
    private EntityTransaction transactionMock;

    @Mock
    private Employee employeeMock;

    @Test
    void save() {
        // given
        when(emMock.getTransaction()).thenReturn(transactionMock);

        // when
        target.save(employeeMock);

        // then
        verify(transactionMock).begin();
        verify(emMock).persist(eq(employeeMock));
        verify(transactionMock).commit();
    }

    @Test
    void get() {
        // given
        long id = 3675234L;
        when(emMock.find(eq(Employee.class), eq(id))).thenReturn(employeeMock);

        // when
        Employee employee = target.get(id);

        // then
        verify(emMock).find(eq(Employee.class), eq(id));

        assertEquals(employee, employeeMock);
    }
}
