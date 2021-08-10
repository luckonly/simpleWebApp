package com.godeltech.simplewebapp.dao;

import com.godeltech.simplewebapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoEmployee extends JpaRepository<Employee, Long> {

}
