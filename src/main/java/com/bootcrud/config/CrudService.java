package com.bootcrud.config;

import java.util.List;
import java.util.Optional;

public interface CrudService {

	public List<Employee> getEmployees();
	
	public Optional<Employee> getEmployee(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
	
	public List<Employee> orderEmployee();
}
