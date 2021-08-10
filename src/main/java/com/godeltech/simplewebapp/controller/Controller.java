package com.godeltech.simplewebapp.controller;

import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.exception.InvalidArgumentException;
import com.godeltech.simplewebapp.service.ServiceEmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class Controller {

    @Autowired
    ServiceEmployeeImpl serviceEmployee;

    @GetMapping("/get-all")
    public List<Employee> getAllEmployees() {
        return serviceEmployee.getAllEmployees();
    }

    @GetMapping("/get-by-id")
    public Employee getEmployee(@RequestParam(name = "id") Long id) throws InvalidArgumentException {
        return serviceEmployee.getEmployee(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) throws InvalidArgumentException {
        return serviceEmployee.addEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestParam(name = "id") Long id, @RequestBody Employee employee) throws InvalidArgumentException {
        return serviceEmployee.updateEmployee(id, employee);
    }

    @DeleteMapping
    public boolean deleteEmployee(@RequestParam(name = "id") Long id) throws InvalidArgumentException {
        serviceEmployee.deleteEmployee(id);
        return true;
    }

}
