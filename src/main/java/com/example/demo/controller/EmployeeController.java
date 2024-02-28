package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.application.domainService.EmployeeDomainService;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200/")

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
//	private EmployeeDomainService employeeDomainService;
//
//	public EmployeeController(EmployeeDomainService employeeDomainService) {
//		super();
//		this.employeeDomainService = employeeDomainService;
//	}
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee rest API
	// ResponseEntity<Employee>  return type
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
// build get all employees rest API
	@GetMapping()
	public List<Employee> getEmployee(){
		return employeeService.getEmployee();
	}
	// build get  employees by id rest api
	// http://localhost:8080/api/employees/1
//	@GetMapping("{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
//		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
//		
//	}
	
	@GetMapping("{code}")
	public ResponseEntity<Employee> getEmployeeByCode(@PathVariable("code") String userName){
		return new ResponseEntity<Employee>(employeeService.findByUsername(userName), HttpStatus.OK);
		
	}
	
	// build update employee rest api
	// http://localhost:8080/api/employees/1 and information 
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id ,@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	// build delete employee rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee( @PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		  return String.format("Hello %s!", name);
		
	}
	
}

