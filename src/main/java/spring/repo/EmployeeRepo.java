package spring.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.model.Employee;    						//ESTABLISH CONNECTION B/W DB

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
