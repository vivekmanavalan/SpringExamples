package com.bootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcrud.UserDetails;

import java.util.Optional;

public interface BootcrudDao extends JpaRepository<UserDetails, Integer>{

    Optional<UserDetails> findByName(String username);
}
