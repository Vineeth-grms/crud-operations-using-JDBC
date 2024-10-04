package com.example.controller;

import com.example.database.EmployeeTest;
import com.example.model.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEmpId(222);

		EmployeeTest test = new EmployeeTest();
		int result = test.deleteEmployee(emp);

		if (result > 0) {
			System.out.println("Row Deleted successfully..");
		} else {
			System.out.println("You Got An Error");
		}
	}

}
