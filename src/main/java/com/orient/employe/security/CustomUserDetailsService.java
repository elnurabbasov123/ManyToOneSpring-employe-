package com.orient.employe.security;

import com.orient.employe.entity.Employe;
import com.orient.employe.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeRepository employeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employe employe=employeRepository.findByUserName(username);

        if(employe==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(employe);



    }
}
