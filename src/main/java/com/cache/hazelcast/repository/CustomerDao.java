package com.cache.hazelcast.repository;

import com.cache.hazelcast.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao  extends JpaRepository<Customer, Integer> {
}
