package com.bootcrud.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This project is using the entitymanager with standard JPA API

@RestController
public class CrudController {

	@Autowired
	private CrudService service;
	
	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
		
	}
	
	@RequestMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return service.getEmployee(id);
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmp(@RequestBody Employee emp) {
		service.save(emp);
		return emp;
	}
	
	@RequestMapping("/deleteEmployee/{id}")
	public Employee deleteEmp(@PathVariable int id) {
		
		return service.delete(id);
	}
}
