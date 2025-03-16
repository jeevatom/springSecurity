package com.security.security.Services;

import com.security.security.Dto.AuthResponse;
import com.security.security.Models.User;
import com.security.security.Repository.userRepo;
import com.security.security.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
   userRepo repo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public ResponseEntity<User> ResgiterUserService(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
       return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED) ;
    }

    public ResponseEntity<AuthResponse> loginService(User user) {


        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            // If authentication is successful, generate a JWT token
            if (authentication.isAuthenticated()) {
                String token = jwtUtil.generateToken(user.getUsername());
                User dbUser = repo.findByUsername(user.getUsername());
                String role = dbUser.getRole();
                AuthResponse authResponse = new AuthResponse(token, user.getUsername(), role);
                return ResponseEntity.ok(authResponse);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
