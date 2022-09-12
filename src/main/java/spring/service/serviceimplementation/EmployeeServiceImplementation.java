package spring.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Annotation.NoDataFoundException;
import spring.Annotation.ResourceNotFoundException;
import spring.model.Employee;
import spring.repo.EmployeeRepo;
import spring.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	private Object employeeList;
	
	

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=empRepo.save(employee);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=empRepo.save(employee);
		return emp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee getEmployee(Integer id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee1=empRepo.findById(id);
		
		
		if(!employee1.isPresent())
		{
			throw new ResourceNotFoundException ("Employee is not found for id-->"+id);
		}
		
		
		Employee employeeResponse =employee1.get();
		return employeeResponse;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employeeList= empRepo.findAll();
		if(employeeList.isEmpty())
		{
			throw new NoDataFoundException("No Employees Data Found");
		}
		
		return employeeList;
	}
	
	
	/*//Exception Handling
	
	public static List<Employee> list=new ArrayList<>();
	public List<Employee> getList()
	
	throws Exception{
		if(list.isEmpty())
		{
			return list;
		}
		throw new NoDataFoundException("No Employees Data Found"); */

		
	}
	


