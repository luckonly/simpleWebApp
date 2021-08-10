package com.godeltech.simplewebapp.dto;

import com.godeltech.simplewebapp.entity.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {

    @NonNull
    Long employeeId;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    @NonNull
    Long departmentId;

    @NonNull
    String jobTitle;

    @NonNull
    Gender gender;

    @NonNull
    LocalDate dateOfBirth;

    @NonNull
    boolean deleted;

}
