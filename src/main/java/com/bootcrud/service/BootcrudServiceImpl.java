package com.bootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcrud.UserDetails;
import com.bootcrud.dao.BootcrudDao;

@Service
public class BootcrudServiceImpl implements BootcrudService {

	@Autowired
	private BootcrudDao userDao;
	@Override
	public List<UserDetails> getAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public UserDetails save(UserDetails user) {
		// TODO Auto-generated method stub
		try {
		userDao.save(user);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		try {
		userDao.deleteById(id);
		return "Deleted Successfully";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public Optional<UserDetails> update(UserDetails updateUser) {
		// TODO Auto-generated method stub
		Optional<UserDetails> user = userDao.findById(updateUser.getId());
		if(!user.isEmpty()) {
			userDao.save(updateUser);
		}
		return Optional.of(updateUser);
	}

}
