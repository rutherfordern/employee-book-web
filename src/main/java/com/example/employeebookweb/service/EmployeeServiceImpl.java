package com.example.employeebookweb.service;

import com.example.employeebookweb.exceptions.EmployeeExistException;
import com.example.employeebookweb.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employee = new ArrayList<>();


    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);

        if (employee.contains(employee1)) {
            throw new EmployeeExistException();
        }
        return employee.add(new Employee(firstName, lastName));
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);

        if (employee.contains(employee1)) {
            return employee.remove(employee1);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        Employee employee1 = new Employee(firstName, lastName);

        for (Employee valueEmployee : employee) {
            if (valueEmployee.equals(employee1)) {
                return valueEmployee;
            }
        }
        throw new EmployeeNotFoundException();
    }

}
