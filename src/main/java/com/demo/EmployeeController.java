package com.demo;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	EmployeeDAOImpl impl = new EmployeeDAOImpl();
	
	
	@RequestMapping(value="/dummy",method=RequestMethod.GET)
	public Employee getEmployeeDummy()
	{
		Employee emp = new Employee();
		emp.setId(101);
		emp.setName("name");
		emp.setSalary(3456);
		impl.addEmployee(emp);
		return emp;
	}


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee emp)
	{
		boolean res = impl.addEmployee(emp);
		if(res)
			return "Success";
		else
			return "Failed";	
	}
	

	@RequestMapping(value="/get/emp/{id}",method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id")int id)
	{
		Employee emp = impl.getEmployee(id);
		System.out.println(emp);
		return emp;
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Employee> getAll()
	{
		return impl.listAll();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")int id)
	{
	boolean res = impl.deleteEmployee(id);
	if(res)
		return "Success";
	else
		return "false";
	}
	
	
	
}
