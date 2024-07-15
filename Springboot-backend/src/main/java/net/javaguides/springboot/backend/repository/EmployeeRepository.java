package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}