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

INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Alexey', 'Ivanov', '12', 'Content manager', 'MALE', '19900410', '0');
INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Ivan', 'Petrov', '11', 'Business analytic', 'MALE', '19900912', '0');
INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Dmitry', 'Maksimov', '10', 'Developer', 'MALE', '19790611', '0');
INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Elena', 'Dmitrieva', '9', 'Marketing', 'FEMALE', '19850424', '0');
INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Natalya', 'Petrova', '10', 'Developer', 'FEMALE', '19910414', '0');
INSERT INTO simpleWebApp.employees(first_name, last_name, department_id, job_title, gender, date_of_birth, deleted)
VALUES ('Olga', 'Ivanova', '11', 'Product manager', 'FEMALE', '19890408', '0');
