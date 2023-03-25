package com.bootcrud.controller;

import java.util.List;
import java.util.Optional;


import com.bootcrud.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import com.bootcrud.UserDetails;
import com.bootcrud.service.BootcrudService;
import com.bootcrud.dto.AuthRequest;

@RestController
@RequestMapping("/jwt")
public class BootcrudController {

	@Autowired
	private BootcrudService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/welcome")
	public String welcome(){
		return "Welcome to JWT Authentication";
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserDetails> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/save")
	public UserDetails save(@RequestBody UserDetails user) {
		return userService.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return userService.delete(id);
	}
	
	@PutMapping("/update")
	public Optional<UserDetails> update(@RequestBody UserDetails user) {
		return userService.update(user);
		
	}

	//JWT Token authentication starts
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthRequest authRequest){
		System.out.print("calling the jwt authentication");
		Authentication authentication = authenticationManager.
				authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.getToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("invalid request");
		}
	}
}
