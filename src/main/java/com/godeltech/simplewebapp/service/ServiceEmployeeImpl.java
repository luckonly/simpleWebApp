package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.dao.EmployeeRepository;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeOrThrowNotFound(Long id) {
        log.debug("Method call \"getEmployeeOrThrowNotFound\" with id {}", id);
        return employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Employee with id \"%s\" not found.", id))
                );
    }

    @Override
    public Employee updateEmployeeOrThrowNotFound(Long id, Employee employee) {
        log.debug("Method call \"updateEmployeeOrThrowNotFound\" with id {} and employee {}", id, employee);
        Employee employee1 = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Employee with id \"%s\" not found.", id))
                );

        return employeeRepository.save(employee1
                .setDateOfBirth(employee.getDateOfBirth())
                .setDepartmentId(employee.getDepartmentId())
                .setGender(employee.getGender())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName()));
    }

    @Override
    public void deleteEmployeeOrThrowNotFoundException(Long id) {
        log.debug("Method call \"deleteEmployeeOrThrowNotFoundException\" with id {}", id);
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Employee with id \"%s\" not found.", id))
                );

        employeeRepository.delete(employee);

    }

    @Override
    public Employee addEmployee(Employee employee) {
        log.debug("Method call \"addEmployee\" with employee {}", employee);
        return employeeRepository.save(employee);
    }
}
