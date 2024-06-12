package com.gabriel.backendapi_spring.repository;

import com.gabriel.backendapi_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
