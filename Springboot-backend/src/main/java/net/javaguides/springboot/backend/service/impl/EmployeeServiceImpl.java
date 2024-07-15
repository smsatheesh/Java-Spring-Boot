package net.javaguides.springboot.backend.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;
import net.javaguides.springboot.backend.model.Employee;
import net.javaguides.springboot.backend.repository.EmployeeRepository;
import net.javaguides.springboot.backend.service.EmployeeService;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save( employee );
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById( long id ) {
//		Optional<Employee> employee = employeeRepository.findById( id );
//		
//		if ( employee.isPresent()){
//			employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException( "Employee", "Id", id );
//		}
//		return null;
		
		return employeeRepository.findById( id ).orElseThrow(() ->
					new ResourceNotFoundException( "Employee", "Id", id ));
	}
	
	@Override
	public Employee updateEmployee( Employee employee, long employeeId ) {
		
		// we need to check whether employee with id is exist in DB
		
		Employee existingEmployee =  employeeRepository.findById( employeeId )
												.orElseThrow(() -> new ResourceNotFoundException( "Employee", "Id", employeeId ));
		
		existingEmployee.setFirstName( employee.getFirstName());
		existingEmployee.setLastName( employee.getLastName());
		existingEmployee.setEmail( employee.getEmail());
		
		// save exiting employee to DB
		employeeRepository.save( existingEmployee );
				
		return existingEmployee;
	}
	
	@Override
	public void deleteEmployee( long employeeId ) {
		
		employeeRepository.findById( employeeId )
										.orElseThrow(() -> new ResourceNotFoundException( "Employee", "Id", employeeId ));
		
		employeeRepository.deleteById( employeeId );
		
	}
	
}
