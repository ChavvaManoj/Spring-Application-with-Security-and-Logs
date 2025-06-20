package com.example.SpringBootRest.service;


import com.example.SpringBootRest.model.User;
import com.example.SpringBootRest.model.userPrinciple;
import com.example.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = repo.findByUsername(username);
        if(user == null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("User Not Found");
        }

        return new userPrinciple(user);
    }

}
