package com.bootcrud.config;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService {

	@Autowired
	private CrudDao dao;
	
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return dao.getEmployees();
	}


	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}


	@Override
	@Transactional
	public void save(Employee emp) {
		dao.save(emp);
		
	}


	@Override
	@Transactional
	public Employee delete(int id) {
		return dao.delete(id);		
	}

}
