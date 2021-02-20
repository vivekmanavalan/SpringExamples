package com.boot.main;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee findbyId(int id);

	public Employee save(Employee emp);

	public void delete(int id);
}
