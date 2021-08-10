package com.godeltech.simplewebapp.dto;

import com.godeltech.simplewebapp.entity.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {

    Long employeeId;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    Long departmentId;

    String jobTitle;

    Gender gender;

    LocalDate dateOfBirth;

    boolean deleted;

}
