package com.godeltech.simplewebapp.controller;

import com.godeltech.simplewebapp.dto.EmployeeDTO;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.factory.EmployeeDTOFactory;
import com.godeltech.simplewebapp.service.ServiceEmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class Controller {

    @Autowired
    ServiceEmployeeImpl serviceEmployee;

    @Autowired
    EmployeeDTOFactory employeeDTOFactory;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return serviceEmployee.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(serviceEmployee
                        .getEmployeeOrThrowNotFound(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(
                        serviceEmployee
                                .addEmployee(employee)
                )
        );
   }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(serviceEmployee
                        .updateEmployeeOrThrowNotFound(id, employee)
                )
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "id") Long id) {
        serviceEmployee.deleteEmployeeOrThrowNotFoundException(id);
        return ResponseEntity.ok(true);
    }

}
