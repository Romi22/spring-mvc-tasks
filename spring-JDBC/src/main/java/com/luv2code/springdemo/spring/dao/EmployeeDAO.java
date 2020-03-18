package com.luv2code.springdemo.spring.dao;

import com.luv2code.springdemo.model.Employee;
import java.util.List;

public interface EmployeeDAO {
	Employee getEmployeeById(Integer id);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
}
