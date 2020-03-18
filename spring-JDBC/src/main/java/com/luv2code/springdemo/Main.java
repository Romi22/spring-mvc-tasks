package com.luv2code.springdemo;


import com.luv2code.springdemo.model.Employee;
import com.luv2code.springdemo.spring.config.AppConfig;
import com.luv2code.springdemo.spring.dao.EmployeeDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

		System.out.println("List of employees is:");

		for (Employee e : employeeDAO.getAllEmployees()) {
			System.out.println(e);
		}

		System.out.println("\nGet employee with ID 2");

		Employee employeeById = employeeDAO.getEmployeeById(2);
		System.out.println(employeeById);

		System.out.println("\nCreating employee: ");
		Employee employee = new Employee(4,"Loci","FAWB");
		System.out.println(employee);
		employeeDAO.createEmployee(employee);
		System.out.println("\nList of employee is:");

		for (Employee e : employeeDAO.getAllEmployees()) {
			System.out.println(e);
		}

		System.out.println("\nDeleting employee with ID 2");
		employeeDAO.deleteEmployee(employeeById);

		System.out.println("\nUpdate employee with ID 4");

		Employee employee1 = employeeDAO.getEmployeeById(4);
		employee1.setName("CHANGED");
		employeeDAO.updateEmployee(employee1);

		System.out.println("\nList of employees is:");
		for (Employee e : employeeDAO.getAllEmployees()) {
			System.out.println(e);
		}

		context.close();
	}
}
