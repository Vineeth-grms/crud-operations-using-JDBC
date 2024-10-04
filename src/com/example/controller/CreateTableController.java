package com.example.controller;

import com.example.database.EmployeeTest;

public class CreateTableController {
	public static void main(String[] args) {
		EmployeeTest test = new EmployeeTest();
		test.createEmployeeTable();
		System.out.println("Table created successfull..");

	}

}
