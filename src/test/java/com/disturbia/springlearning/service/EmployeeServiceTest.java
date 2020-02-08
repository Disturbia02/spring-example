package com.disturbia.springlearning.service;

import com.disturbia.springlearning.entity.Employee;
import com.disturbia.springlearning.model.Response;
import com.disturbia.springlearning.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {


    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        employeeService = new EmployeeService(employeeRepository);

    }

    @Test
    public void ShouldSplitWhenNameIsValid() throws NotFoundException {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Rahat Sarawassee");
        employee.setAge(22);
        when(employeeRepository.findById(anyLong())).thenReturn(java.util.Optional.of(employee));

        Response response = employeeService.findByIdSplit(1L);

        assertEquals("Rahat", response.getName());
        System.out.println("tesst");
    }
}