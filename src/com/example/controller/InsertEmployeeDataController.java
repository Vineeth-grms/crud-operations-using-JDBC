package com.example.controller;

import com.example.database.EmployeeTest;
import com.example.model.Employee;

public class InsertEmployeeDataController {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEmpId(343);
		emp.setEmpName("abhishek");
		emp.setSalary(4567.50);
		emp.setDepartment("ECE");

		EmployeeTest test = new EmployeeTest();
		int result = test.insertEmployee(emp);

		if (result > 0) {
			System.out.println("Data inserted successfully");
		} else {
			System.out.println("You Got Error");
		}

	}

}
