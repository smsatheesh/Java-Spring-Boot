package net.javaguides.springboot.backend.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.backend.model.Employee;
import net.javaguides.springboot.backend.service.EmployeeService;
import java.util.*;

@RestController
@RequestMapping( "/api/employees" )
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController( EmployeeService employeeService ) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee ){
		return new ResponseEntity<Employee>( employeeService.saveEmployee( employee ), HttpStatus.CREATED );
	}
	
	// build get employee REST API
	@GetMapping()
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/employees/:id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById( @PathVariable( "id" ) long employeeId ) {
		return new ResponseEntity<Employee>( employeeService.getEmployeeById( employeeId ), HttpStatus.OK );
	}
	
	// build update employee REST API
	// http://localhost:8080/api/employees/:id
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee, @PathVariable( "id" ) long employeeId ) {
		return new ResponseEntity<Employee>( employeeService.updateEmployee( employee, employeeId ), HttpStatus.OK );
	}
	
	// build delete REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee( @PathVariable( "id" ) long employeeId) {
		employeeService.deleteEmployee( employeeId );
		return new ResponseEntity<String>( "Employee deleted successfully !", HttpStatus.OK );
	}
}
