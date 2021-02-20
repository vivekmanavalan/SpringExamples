package com.bootcrud.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This project is using SpringData JPA by extending the JPARepository

@RestController
public class CrudController {

	@Autowired
	private CrudService service;
	
	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
		
	}
	
	@RequestMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return service.getEmployee(id);
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmp(@RequestBody Employee emp) {
		service.save(emp);
		return emp;
	}
	
	@RequestMapping("/deleteEmployee/{id}")
	public void deleteEmp(@PathVariable int id) {
		 service.delete(id);
	}
	
	@RequestMapping("/orderEmployees")
	public List<Employee> orderEmployees(){
		return service.orderEmployee();
	}
}
