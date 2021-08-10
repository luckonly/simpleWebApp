package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.dao.DaoEmployee;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.exception.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    @Autowired
    DaoEmployee daoEmployee;

    @Override
    public List<Employee> getAllEmployees() {
        return daoEmployee.findAll();
    }

    @Override
    public Employee getEmployee(Long id) throws InvalidArgumentException {

        Optional<Employee> optionalEmployee = daoEmployee.findById(id);
        return optionalEmployee.orElseThrow(() -> new InvalidArgumentException("Employee with id " + id + " not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws InvalidArgumentException {

        Optional<Employee> optionalEmployee = daoEmployee.findById(id);

        if (!optionalEmployee.isPresent()) {
            optionalEmployee.orElseThrow(() -> new InvalidArgumentException("Employee with id " + id + " not found"));
        }

        return optionalEmployee.get()
                .setDateOfBirth(employee.getDateOfBirth())
                .setDepartmentId(employee.getDepartmentId())
                .setGender(employee.getGender())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName());
    }

    @Override
    public void deleteEmployee(Long id) throws InvalidArgumentException {

        Optional<Employee> optionalEmployee = daoEmployee.findById(id);

        if (!optionalEmployee.isPresent()) {
            optionalEmployee.orElseThrow(() -> new InvalidArgumentException("Employee with id " + id + " not found"));
        }

        optionalEmployee.get().setDeleted(true);

    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee employee1 = daoEmployee.save(employee);
        return employee1;
        //        return daoEmployee.save(employee);
    }
}
