package com.example.employeebookweb.service;

import com.example.employeebookweb.exceptions.EmployeeBookOverFlowException;
import com.example.employeebookweb.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

    void  addEmployee(String firstName, String lastName) throws EmployeeBookOverFlowException;

    void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

}
