package com.customer.report.services;

import com.customer.report.entity.User; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.report.repository.UserRepository; 

@Service
public class  UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
}