CREATE SCHEMA if not exists simpleWebApp;

CREATE TABLE IF NOT EXISTS simpleWebApp.employees
(
    employee_id bigserial primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    department_id bigint not null,
    job_title varchar(50) not null,
    gender varchar(15) not null,
    date_of_birth DATE,
    deleted BOOLEAN
);

INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('1', 'Alexey', 'Ivanov', '12', 'Content manager', 'MALE', '19900410', '0');
INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('2', 'Ivan', 'Petrov', '11', 'Business analytic', 'MALE', '19900912', '0');
INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('3', 'Dmitry', 'Maksimov', '10', 'Developer', 'MALE', '19790611', '0');
INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('4', 'Elena', 'Dmitrieva', '9', 'Marketing', 'FEMALE', '19850424', '0');
INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('5', 'Natalya', 'Petrova', '10', 'Developer', 'FEMALE', '19910414', '0');
INSERT INTO simpleWebApp.employees(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('6', 'Olga', 'Ivanova', '11', 'Product manager', 'FEMALE', '19890408', '0');
