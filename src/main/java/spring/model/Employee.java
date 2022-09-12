package spring.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee1")
public class Employee {

	@Id
	@GeneratedValue(generator="emp_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="emp_seq",sequenceName="emp_sequence",initialValue=1,allocationSize=1)
	
	private Integer id;

	// @Column(name="empname")
	private String name;

	// @Column(name="empsalary")
	private BigDecimal salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String name, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
