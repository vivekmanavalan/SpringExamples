package com.bootcrud.config;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrudDaoImpl implements CrudDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployees() {
		Query theQuery = (Query) entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp =  entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		
		entityManager.merge(emp);
	}

	@Override
	public Employee delete(int id) {
		Employee emp = entityManager.find(Employee.class,id);
		Query theQuery = (Query) entityManager.createQuery("delete from Employee where id=:theId");
		theQuery.setParameter("theId", id);
		theQuery.executeUpdate();
		return emp;
		
		
	}

}
