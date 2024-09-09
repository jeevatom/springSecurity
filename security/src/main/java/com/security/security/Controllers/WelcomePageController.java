package com.security.security.Controllers;
import com.security.security.Services.WelcomePageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class WelcomePageController {
    @Autowired
    WelcomePageService service;
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomePage(HttpServletRequest req,@RequestParam String name){
      return  service.welcomePageSer(req,name);
    }
}
