package com.hunsy.pointshop.service;

import com.hunsy.pointshop.entity.AppDeveloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private DeveloperService developerService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppDeveloper developer = developerService.findByMobile(username);
        if (developer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(developer.getMobile(), developer.getPassword(), Collections.emptyList());
    }
}
