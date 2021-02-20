package com.boot.main;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	@Transactional
	public Employee findbyId(int id) {
		// TODO Auto-generated method stub
		return dao.findbyId(id);
	}
	@Override
	@Transactional
	public Employee save(Employee emp) {
		
		return dao.save(emp);
	}
	@Override
	@Transactional
	public void delete(int id) {
		
		dao.delete(id);
	}

}
