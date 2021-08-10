package com.godeltech.simplewebapp.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employees", schema = "simplewebapp")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Builder
public class Employee implements Serializable {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;

    @Column(name = "first_name")
    @NotBlank
    String firstName;

    @Column(name = "last_name")
    @NotBlank
    String lastName;

    @Column(name = "department_id")
    Long departmentId;

    @Column(name = "job_title")
    String jobTitle;

    @Column
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;

    @Column
    boolean deleted;
}
