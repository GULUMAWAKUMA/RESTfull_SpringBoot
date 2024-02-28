package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
Employee saveEmployee(Employee employee);
List<Employee> getEmployee();
Employee getEmployeeById(Long id);
Employee updateEmployee(Employee employee, Long id);
void deleteEmployee(Long id);
//Employee getEmployeeByCode(String employeeUsername);
Employee findByUsername(String userName);
}
