package com.customer.report.Controller;

import com.customer.report.dto.LoginDTO;
import com.customer.report.entity.User;
import com.customer.report.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Users")
public class UserController {
    @Autowired
    private UserService userService;
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody LoginDTO user) {
        User u =userService.login(user.getUsername(), user.getPassword());
        if(u==null){
            return null;// ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(u);
    }
}