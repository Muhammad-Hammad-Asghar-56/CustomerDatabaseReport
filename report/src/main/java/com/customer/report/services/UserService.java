package com.customer.report.services;

import com.customer.report.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.report.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class  UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
}