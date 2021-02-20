package com.bootcrud.config;

import java.util.List;
import java.util.Optional;

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
		return dao.findAll();
	}


	@Override
	public Optional<Employee> getEmployee(int id) {
		return dao.findById(id);
	}


	@Override
	@Transactional
	public void save(Employee emp) {
		dao.save(emp);
		
	}


	@Override
	@Transactional
	public void delete(int id) {
		dao.deleteById(id);		
	}


	@Override
	public List<Employee> orderEmployee() {
		// TODO Auto-generated method stub
		return dao.result();
	}

}
