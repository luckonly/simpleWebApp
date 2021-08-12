package com.godeltech.simplewebapp.controller;

import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.service.ServiceEmployeeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/employees")
public class Controller {

    @Autowired
    ServiceEmployeeImpl serviceEmployee;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Method call \"getAllEmployees\"");
        return ResponseEntity.ok(serviceEmployee.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@NotNull @PathVariable(name = "id") Long id) {
        log.info("Method call \"getEmployee\" with id \"{}\"", id);
        return ResponseEntity.ok(serviceEmployee
                .getEmployeeOrThrowNotFound(id)
        );
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        log.info("Method call \"addEmployee\" for object \"{}\"", employee);
        return ResponseEntity.ok(serviceEmployee
                .addEmployee(employee)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@NotNull @PathVariable(name = "id") Long id,
                                                   @Valid @RequestBody Employee employee) {
        log.info("Method call \"updateEmployee\" by id \"{}\"", id);
        return ResponseEntity.ok(serviceEmployee
                .updateEmployeeOrThrowNotFound(id, employee)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@NotNull @PathVariable(name = "id") Long id) {
        log.info("Method call \"deleteEmployee\" by id \"{}\"", id);
        serviceEmployee.deleteEmployeeOrThrowNotFoundException(id);
        return ResponseEntity.ok(true);
    }
}
