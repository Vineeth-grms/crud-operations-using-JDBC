package com.example.controller;

import java.util.List;

import com.example.database.EmployeeTest;
import com.example.model.Employee;

public class GetAllEmployees {
	public static void main(String[] args) {

		EmployeeTest test = new EmployeeTest();
		List<Employee> list = test.getAllEmployees();
		if (list != null) {
			for (Employee emp : list) {
				System.out.println("Emp Id         : " + emp.getEmpId());
				System.out.println("Emp Name       : " + emp.getEmpName());
				System.out.println("Emp Salary     : " + emp.getSalary());
				System.out.println("Emp Department : " + emp.getDepartment());
				System.out.println("--------------------------------------------------");
			}

		}

	}

}
