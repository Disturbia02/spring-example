package com.disturbia.springlearning.service;

import com.disturbia.springlearning.entity.Employee;
import com.disturbia.springlearning.model.Response;
import com.disturbia.springlearning.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee request) {
        return employeeRepository.save(request);
    }

    public Employee findById(Long id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
    }

    public Response findByIdSplit(Long id) throws NotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
        String[] splitName = employee.getName().split(" ");
        String name = splitName[0];
        String surname = splitName[1];

        Response response = new Response();
        response.setId(employee.getId());
        response.setName(name);
        response.setSurname(surname);
        response.setAge(employee.getAge());
        return response;
    }

    public void deleteId(Long id)throws NotFoundException {
        findById(id);
        employeeRepository.deleteById(id);
    }
    public Employee updateById(Long id,Employee request) throws NotFoundException{
        findById(id);
        request.setId(id);
        return employeeRepository.save(request);
    }
}
