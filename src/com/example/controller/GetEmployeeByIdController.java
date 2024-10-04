package com.example.controller;

import com.example.database.EmployeeTest;
import com.example.model.Employee;

public class GetEmployeeByIdController {
	public static void main(String[] args) {

		EmployeeTest test = new EmployeeTest();
		Employee emp = test.getEmployeeById(343);
		if (emp != null) {
			System.out.println("Emp Id         : " + emp.getEmpId());
			System.out.println("Emp Name       : " + emp.getEmpName());
			System.out.println("Emp Salary     : " + emp.getSalary());
			System.out.println("Emp Department : " + emp.getDepartment());
			System.out.println("--------------------------------------------------");
		}else {
			System.out.println("You Got An Error.");
		}

	}

}
