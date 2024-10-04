package com.example.controller;

import com.example.database.EmployeeTest;
import com.example.model.Employee;

public class UpdateEmployeeController {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEmpId(111);
		emp.setEmpName("Virat Dhoni");
		emp.setSalary(1000);

		EmployeeTest test = new EmployeeTest();
		int result = test.updateEmployee(emp);

		if (result > 0) {
			System.out.println("Table Data Updated Successfully..");
		} else {
			System.out.println("You Got an Error");
		}
	}

}
