package com.security.security.Controllers;

import com.security.security.Dto.AuthResponse;
import com.security.security.Models.User;
import com.security.security.Services.UserService;
import com.security.security.Util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> loginController(@RequestBody User user){
    return  service.loginService(user);
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("im here");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(1);
        if (auth != null) {
            System.out.println(2);
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.clearContext(); // Ensure security context is cleared
        }
        return ResponseEntity.ok("Logged out successfully test test");
    }


    @PostMapping("signup")
    public ResponseEntity<User> registerController(@RequestBody User user){
        return service.ResgiterUserService(user);
    }


}
