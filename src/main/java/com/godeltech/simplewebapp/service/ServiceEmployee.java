package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.exception.InvalidArgumentException;

import java.util.List;

public interface ServiceEmployee {
    List<Employee> getAllEmployees();
    Employee getEmployee(Long id) throws InvalidArgumentException;
    Employee updateEmployee(Long id, Employee employee) throws InvalidArgumentException;
    void deleteEmployee(Long id) throws InvalidArgumentException;
    Employee addEmployee(Employee employee);
}
