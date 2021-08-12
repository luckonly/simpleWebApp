package com.godeltech.simplewebapp.service;

import com.godeltech.simplewebapp.dao.EmployeeRepository;
import com.godeltech.simplewebapp.entity.Employee;
import com.godeltech.simplewebapp.entity.Gender;
import com.godeltech.simplewebapp.exception.NotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

@SpringBootTest
@ContextConfiguration(initializers = {ServiceEmployeeImplTest.Initializer.class})
@Testcontainers
class ServiceEmployeeImplTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13")
            .withDatabaseName("test-db-employee")
            .withUsername("sa")
            .withPassword("sa");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword(),
                    "spring.liquibase.enabled=true",
                    "spring.liquibase.change-log=classpath:changelog/test.db.changelog-master.xml",
                    "spring.jpa.hibernate.ddl-auto=validate"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    private long employee_id = 1L;
    private long employee_id_wrong = 10000000L;

    @Test
    void givenEmployees_whenGetEmployees_thenResultListNotEmpty() {
        Assert.assertFalse(employeeRepository.findAll().isEmpty());
    }

    @Test()
    void givenEmployees_whenGetById_thenResultNotNull() {
        Assert.assertNotNull(employeeRepository.getById(employee_id));
     }

    @Test()
    void givenEmployeesAndWrongId_whenGetById_thenThrowNotFound() {
        Assert.assertThrows(NotFoundException.class, () -> {
            employeeRepository.findById(employee_id_wrong)
                    .orElseThrow(() -> new NotFoundException(""));
        });
    }

    @Test
    void givenEmployeeUpdateInfo_whenUpdateEmployee_thenReturnUpdatedInfo() {

        String firstName = "Olga";
        String lastName = "Ivanova";
        Gender gender = Gender.FEMALE;
        long departmentId = 29L;
        LocalDate dateOfBirth = LocalDate.of(1988, 05, 26);
        String jobTitle = "Developer";
        boolean deleted = true;

        Employee employee = employeeRepository.findById(employee_id).get();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setDepartmentId(departmentId);
        employee.setDateOfBirth(dateOfBirth);
        employee.setJobTitle(jobTitle);
        employee.setDeleted(deleted);

        employeeRepository.save(employee);
        employee = employeeRepository.findById(employee_id).get();

        Assert.assertEquals(firstName, employee.getFirstName());
        Assert.assertEquals(lastName, employee.getLastName());
        Assert.assertEquals(gender, employee.getGender());
        Assert.assertSame(departmentId, employee.getDepartmentId());
        Assert.assertEquals(dateOfBirth, employee.getDateOfBirth());
        Assert.assertEquals(jobTitle, employee.getJobTitle());
        Assert.assertEquals(deleted, employee.isDeleted());

    }

    @Test
    void givenDeletedById_whenTryToFindById_thenThrowsNotFoundException() {
        employeeRepository.deleteById(employee_id);
        Assert.assertThrows(NotFoundException.class, () -> {
            employeeRepository.findById(employee_id)
                    .orElseThrow(() -> new NotFoundException(""));
        });
    }

}