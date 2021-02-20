package com.bootcrud.config;

import java.util.List;

public interface CrudDao {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public void save(Employee emp);
	
	public Employee delete(int id);
}
