package spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.Annotation.ResourceNotFoundException;
import spring.model.Employee;


public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public Employee getEmployee(Integer id) throws ResourceNotFoundException;
	public List<Employee> getAllEmployee();

}
