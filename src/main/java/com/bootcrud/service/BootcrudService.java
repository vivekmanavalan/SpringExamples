package com.bootcrud.service;

import java.util.List;
import java.util.Optional;

import com.bootcrud.UserDetails;

public interface BootcrudService {
	public List<UserDetails> getAll();
	public UserDetails save(UserDetails user);
	public String delete(int id);
	public Optional<UserDetails> update(UserDetails user);
}
