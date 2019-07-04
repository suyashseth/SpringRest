package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RestController;


public class EmployeeDAOImpl implements EmployeeDAO{

	HashMap<Integer, Employee>map = new HashMap<>();

	@Override
	public boolean addEmployee(Employee emp) {
		if(emp!=null)
		{
			map.put(emp.getId(),emp);
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		
		Employee emp = map.get(id);
		return emp;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Employee emp1 = map.get(emp.getId());
		emp1.setName(emp.getName());
		emp1.setSalary(emp.getSalary());
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		map.remove(id);
		return true;
	}

	@Override
	public List<Employee> listAll() {
		List<Employee>emp = new ArrayList<>();
		Set<Integer>id = map.keySet();
		for(Integer i:id)
		{
			emp.add(map.get(i));
		
		}
		return emp;
	}
	
	
	
	
}
