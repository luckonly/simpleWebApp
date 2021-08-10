package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.entity.Employee;

import java.util.List;

public interface ServiceEmployee {
    List<Employee> getAllEmployees();
    Employee getEmployeeOrThrowNotFound(Long id);
    Employee updateEmployeeOrThrowNotFound(Long id, Employee employee);
    void deleteEmployeeOrThrowNotFoundException(Long id);
    Employee addEmployee(Employee employee);
}
