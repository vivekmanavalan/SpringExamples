package com.boot.main;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = (Query<Employee>) entityManager.createQuery("from Employee", Employee.class);
		List<Employee> result = query.getResultList();
		return result;
	}

	@Override
	public Employee findbyId(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class,id);
		return emp;
	}

	@Override
	public Employee save(Employee emp) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(emp);
		return emp;
		
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery("delete from Employee where id=:emp");
		
		query.setParameter("emp", id);
		
		query.executeUpdate();
		
	}

}
