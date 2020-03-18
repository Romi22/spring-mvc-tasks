package com.luv2code.springdemo.spring.dao;


import com.luv2code.springdemo.model.Employee;
import com.luv2code.springdemo.model.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_EMPLOYEE = "select * from employee where id = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employee where id = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set name = ?, dept = ? where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_EMPLOYEE= "insert into employee(id, name, dept) values(?,?,?)";

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Employee getEmployeeById(Integer id) {
		return jdbcTemplate. queryForObject(SQL_FIND_EMPLOYEE, new Object[] { id }, new EmployeeMapper());
	}

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	public boolean deleteEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getId()) > 0;
	}

	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getName(), employee.getDept(),
				employee.getId()) > 0;
	}

	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getId(), employee.getName(), employee.getDept()) > 0;
	}
}
