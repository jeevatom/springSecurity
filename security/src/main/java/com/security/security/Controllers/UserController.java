package com.security.security.Controllers;

import com.security.security.Models.User;
import com.security.security.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService service;


    @PostMapping("login")
    public ResponseEntity<String> loginController(@RequestBody User user){
    return  service.loginService(user);
    }


    @PostMapping("signup")
    public ResponseEntity<User> registerController(@RequestBody User user){
        return service.ResgiterUserService(user);
    }


}
