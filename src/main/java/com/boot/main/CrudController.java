package com.boot.main;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This project is using entitymanager with native hibernateAPI

@RestController
public class CrudController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return service.findAll();
	}
	
	@RequestMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return service.findbyId(id);
	}
	
	@PostMapping("/saveEmployee")
	public void save(@RequestBody Employee emp) {
		emp.setId(0);
		service.save(emp);
	}
	
	@PutMapping("/updateEmployee")
	public void update(@RequestBody Employee emp) {
		service.save(emp);
	}
	
	@RequestMapping("/deleteEmployee/{id}")
	public void delete(@PathVariable int id) {
		
		service.delete(id);
	}
}
