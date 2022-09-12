package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.Annotation.ResourceNotFoundException;
import spring.model.Employee;
import spring.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Employee e1)
	{
		Employee em=new Employee();
		BeanUtils.copyProperties(e1, em);
		Employee em1=empService.saveEmployee(em);
		String message=null;
		if(em1!=null)
		{
			message="Employee saved sucessfully in Database";
		}
		else
		{
			message="Employee Not saved sucessfully in Database";
		}
		return message;
		
	}
	
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee e1 , @PathVariable Integer id)throws ResourceNotFoundException
	{
		Employee employeeResponse= empService.getEmployee(id);
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(e1.getName());
		employee.setSalary(e1.getSalary());
		Employee employee1=empService.updateEmployee(employee);
		return employee1;

	}
	
	@GetMapping("/get/{id}")
	public Employee findById(@PathVariable Integer id) throws ResourceNotFoundException
	{
		Employee employee =empService.getEmployee(id);
		Employee employeeModel=new Employee();
		if(employee!=null)
		{
			BeanUtils.copyProperties(employee, employeeModel);
		}
		return employeeModel;
	}
	@GetMapping("/getAll")
	public List<Employee> findAll()
	{
		List<Employee> employeeList=empService.getAllEmployee();
		List<Employee> employeeModelList=new ArrayList<>();
		Employee employeeModel=null;
		for(Employee employee:employeeList)
		{
			Employee model=new Employee();
			BeanUtils.copyProperties(employee, model);
			employeeModelList.add(model);
		}
		return employeeModelList;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Integer id)
	{
		empService.deleteEmployee(id);
	}
	


}
