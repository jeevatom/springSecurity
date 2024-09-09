package com.security.security.Services;

import com.security.security.Models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class WelcomePageService {


    public ResponseEntity<String> welcomePageSer(HttpServletRequest req,String name){
        String ser="Hello "+name+" session id is:"+req.getSession().getId();
        return new ResponseEntity<>(ser, HttpStatus.OK);
    }
}
