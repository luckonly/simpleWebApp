package com.godeltech.simplewebapp.controller;

import com.godeltech.simplewebapp.dto.EmployeeDTO;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.factory.EmployeeDTOFactory;
import com.godeltech.simplewebapp.service.ServiceEmployeeImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Log4j2
@RestController
@Validated
@RequestMapping("/api/employees")
public class Controller {

    @Autowired
    ServiceEmployeeImpl serviceEmployee;

    @Autowired
    EmployeeDTOFactory employeeDTOFactory;

    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info(String.format("Вызов метода \"getAllEmployees\""));
        return serviceEmployee.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@NotNull @PathVariable(name = "id") Long id) {
        log.info(String.format("Вызов метода \"getEmployee\" по идентификатору \"%s\"", id));
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(serviceEmployee
                        .getEmployeeOrThrowNotFound(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody Employee employee){
        log.info(String.format("Вызов метода \"addEmployee\" для объекта \"%s\"", employee));
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(
                        serviceEmployee
                                .addEmployee(employee)
                )
        );
   }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@NotNull @PathVariable(name = "id") Long id, @Valid @RequestBody Employee employee) {
        log.info(String.format("Вызов метода \"updateEmployee\" по идентификатору \"%s\"", id));
        return ResponseEntity.ok(employeeDTOFactory
                .createEmployeeDTO(serviceEmployee
                        .updateEmployeeOrThrowNotFound(id, employee)
                )
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@NotNull @PathVariable(name = "id") Long id) {
        serviceEmployee.deleteEmployeeOrThrowNotFoundException(id);
        return ResponseEntity.ok(true);
    }

}
