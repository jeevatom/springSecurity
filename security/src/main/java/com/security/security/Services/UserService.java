package com.security.security.Services;

import com.security.security.Models.User;
import com.security.security.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public ResponseEntity<User> ResgiterUserService(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
       return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED) ;
    }

    public ResponseEntity<String> loginService(User user) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Wrong Credentials",HttpStatus.FORBIDDEN);
        }
    }
}
