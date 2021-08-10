package com.godeltech.simplewebapp.factory;

import com.godeltech.simplewebapp.dto.EmployeeDTO;
import com.godeltech.simplewebapp.entity.Employee;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Component
public class EmployeeDTOFactory {

    public EmployeeDTO createEmployeeDTO(Employee entity) {

        return EmployeeDTO.builder()
                .employeeId(entity.getEmployeeId())
                .dateOfBirth(entity.getDateOfBirth())
                .departmentId(entity.getDepartmentId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .jobTitle(entity.getJobTitle())
                .deleted(entity.isDeleted())
                .build();
    }

    public Employee createEmployeeEntity(EmployeeDTO dto) {
        return Employee.builder()
                .employeeId(dto.getEmployeeId())
                .dateOfBirth(dto.getDateOfBirth())
                .departmentId(dto.getDepartmentId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .jobTitle(dto.getJobTitle())
                .deleted(dto.isDeleted())
                .build();
    }

}
