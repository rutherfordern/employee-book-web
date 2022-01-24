package com.example.employeebookweb.service;

import com.example.employeebookweb.exceptions.EmployeeBookOverFlowException;
import com.example.employeebookweb.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Employee[] employee = new Employee[4];

    @Override
    public void addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(firstName, lastName);
                return;
            }
        }
        throw new EmployeeBookOverFlowException();
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getFirstName().equals(firstName) && employee[i].getLastName().equals(lastName)) {
                employee[i] = null;
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee valueEmployee : employee) {
            if (firstName.equals(valueEmployee.getFirstName()) && lastName.equals(valueEmployee.getLastName())) {
                return valueEmployee;
            }
        }
        throw new EmployeeNotFoundException();
    }

}
