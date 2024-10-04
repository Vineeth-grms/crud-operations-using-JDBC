package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;
import com.mysql.cj.jdbc.Driver;

public class EmployeeTest {

	public static final String url = "jdbc:mysql://localhost:3306/E_commerce";
	public static final String username = "root";
	public static final String password = "@1234";

	public void createEmployeeTable() {
		String query = "create table Employee ( empId int primary key , empName varchar(255)  not null, salary decimal(10,2) , department varchar(255)  not null) ";
		try (Connection connect = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			Statement stat = connect.createStatement();
			stat.execute(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int insertEmployee(Employee emp) {

		String query = "insert into Employee values(?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new Driver());

			PreparedStatement prepare = con.prepareStatement(query);
			prepare.setInt(1, emp.getEmpId());
			prepare.setString(2, emp.getEmpName());
			prepare.setDouble(3, emp.getSalary());
			prepare.setString(4, emp.getDepartment());
			int result = prepare.executeUpdate();
			return result;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}

	public int updateEmployee(Employee emp) {
		String query = "Update Employee set empName = ?,salary = ? Where empId = ?";

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new Driver());

			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, emp.getEmpName());
			pre.setDouble(2, emp.getSalary());
			pre.setInt(3, emp.getEmpId());
			int result = pre.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return 0;

	}

	public int deleteEmployee(Employee emp) {
		String query = "Delete from employee where empId = ?";
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new Driver());

			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, emp.getEmpId());
			int result = pre.executeUpdate();
			return result;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		String query = "select * from Employee";

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new Driver());

			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(query);

			while (res.next()) {
				Employee emp = new Employee();
				emp.setEmpId(res.getInt("empId"));
				emp.setEmpName(res.getString("empName"));
				emp.setSalary(res.getDouble("salary"));
				emp.setDepartment(res.getString("department"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public Employee getEmployeeById(int id) {
		String query = "select * from Employee where empId = ?";
		Employee emp = null;

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			// DriverManager.registerDriver(new Driver());

			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();

			while (res.next()) {
				emp = new Employee();
				emp.setEmpId(res.getInt("empId"));
				emp.setEmpName(res.getString("empName"));
				emp.setSalary(res.getDouble("salary"));
				emp.setDepartment(res.getString("department"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return emp;

	}
}
