package com.bootcrud.config;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//If we extend this JPA repository it has predefined methods for crud operations

@Repository
public interface CrudDao extends JpaRepository<Employee, Integer> {

	
	@Query(value = "SELECT * FROM Employee ORDER BY FIRST_NAME",nativeQuery = true)
	 public List<Employee> result();
}
