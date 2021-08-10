package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.dao.DaoEmployee;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    @Autowired
    DaoEmployee daoEmployee;

    @Override
    public List<Employee> getAllEmployees() {
        return daoEmployee.findAll();
    }

    @Override
    public Employee getEmployeeOrThrowNotFound(Long id){
        return daoEmployee
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Сотрудник с идентификатором \"%s\" не найден.", id))
                );
    }

    @Override
    public Employee updateEmployeeOrThrowNotFound(Long id, Employee employee) {

        Employee employee1 = daoEmployee
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Сотрудник с идентификатором \"%s\" не найден.", id))
                );

        return daoEmployee.save(employee1
                    .setDateOfBirth(employee.getDateOfBirth())
                    .setDepartmentId(employee.getDepartmentId())
                    .setGender(employee.getGender())
                    .setFirstName(employee.getFirstName())
                    .setLastName(employee.getLastName()));
    }

    @Override
    public void deleteEmployeeOrThrowNotFoundException(Long id) {

        Employee employee = daoEmployee
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Сотрудник с идентификатором \"%s\" не найден.", id))
                );

        daoEmployee.delete(employee);

    }

    @Override
    public Employee addEmployee(Employee employee) {
        return daoEmployee.save(employee);
    }
}
