package com.bootcrud.service;

import com.bootcrud.config.UserInfoUserDetails;
import com.bootcrud.dao.BootcrudDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private BootcrudDao repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.bootcrud.UserDetails> user = repository.findByName(username);
        return user.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid Username" + username));
    }
}
