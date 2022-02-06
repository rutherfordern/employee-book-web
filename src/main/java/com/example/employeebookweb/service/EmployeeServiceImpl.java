package com.example.employeebookweb.service;

import com.example.employeebookweb.exceptions.EmployeeExistException;
import com.example.employeebookweb.exceptions.EmployeeNotFoundException;
import com.example.employeebookweb.model.Employee;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Map<String, Employee> employees = new HashMap<>();


    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee testEmployee = new Employee(firstName, lastName);

        String employeeKey = firstName + " " + lastName;

        if (employees.containsKey(employeeKey)) {
            throw new EmployeeExistException();
        } else {
            employees.put(employeeKey, testEmployee);
            return true;
        }
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        Employee testEmployee = new Employee(firstName, lastName);

        String employeeKey = firstName + " " + lastName;

        if (employees.containsKey(employeeKey)) {
            employees.remove(employeeKey);
            return true;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        String employeeKey = firstName + " " + lastName;

        if (employees.containsKey(employeeKey)) {
            return employees.get(employeeKey);
        }
        throw new EmployeeNotFoundException();
    }

}
