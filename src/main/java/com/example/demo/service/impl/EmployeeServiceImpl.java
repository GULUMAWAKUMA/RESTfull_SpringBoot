package com.example.demo.service.impl;

import java.util.List;
//import java.util.Optional;
//

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResorceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

private EmployeeRepository employeeRepository;



public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}



@Override
public Employee saveEmployee(Employee employee) {
//	  if (employee.email == null || employee.email.isEmpty()) {
//          throw new IllegalArgumentException("Email cannot be null or empty");
//      }
	return employeeRepository.save(employee);
}



@Override
public List<Employee> getEmployee() {
	return employeeRepository.findAll();
}



@Override
public Employee getEmployeeById(Long id) {
//	Optional< Employee> employee = employeeRepository.findById(id);
//	if(employee.isPresent()) {
//		return employee.get();
//		
//	} else{
//		throw new ResorceNotFoundException("Employee", "Id",id);
//	}
		return employeeRepository.findById(id).orElseThrow(() -> new ResorceNotFoundException("Employee", "Id", id));
	}



@Override
public Employee updateEmployee(Employee employee, Long id) {
     //  we need to check whether employee with give id exist in DB or Not
	Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Employee", "Id", id));
	
	existingEmployee.setFirstName(employee.getFirstName());
	existingEmployee.setLastName(employee.getLastName());
	existingEmployee.setEmail(employee.getEmail());
	//save existing employee to DB
	employeeRepository.save(existingEmployee);
	
	
	
	return existingEmployee;
}



@Override
public void deleteEmployee(Long id) {
	// check whether a empployee exist in a DB or Not
	employeeRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Employee", "Id", id));
	employeeRepository.deleteById(id);
	
	
}



@Override
public Employee findByUsername(String userName) {
	// TODO Auto-generated method stub
	return employeeRepository.findByUserName(userName);
}




//public Employee getEmployeeByCode(String employeeUsername) {
//	// TODO Auto-generated method stub
//	
//	return (Employee) employeeRepository.findAll();
//	
//}
}

