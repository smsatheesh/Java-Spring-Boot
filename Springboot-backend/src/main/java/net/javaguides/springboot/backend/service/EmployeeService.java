package net.javaguides.springboot.backend.service;

import net.javaguides.springboot.backend.model.Employee;
import java.util.*;

public interface EmployeeService {

	Employee saveEmployee( Employee employee );
	List<Employee> getAllEmployees();
	Employee getEmployeeById( long id );
	Employee updateEmployee( Employee employee, long employeeId );
	void deleteEmployee( long employeeId );
}
