package com.demo;

import java.util.List;

public interface EmployeeDAO {

	public boolean addEmployee(Employee emp);

	public Employee getEmployee(int id);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int id);

	public List<Employee> listAll();
}
