package com.example.employeebookweb.service;

import com.example.employeebookweb.exceptions.EmployeeExistException;
import com.example.employeebookweb.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName) throws EmployeeExistException;

    boolean removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

}
