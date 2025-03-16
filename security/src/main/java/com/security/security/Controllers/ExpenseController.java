package com.security.security.Controllers;

import com.security.security.Dto.DuesProjection;
import com.security.security.Models.ExpenseDetailsEntity;
import com.security.security.Models.ExpenseTypesEntity;
import com.security.security.Models.User;
import com.security.security.Services.ExpenceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenceService service;


    @GetMapping("/getExpenseTypes")
    public ResponseEntity<List<ExpenseTypesEntity>> getExpenseTypeDetails(){
         return service.getExpenseTypeDetails();
    }

    @GetMapping("/getExpenseDetails")
    public ResponseEntity<List<ExpenseDetailsEntity>> getExpenseDetails(){
        return service.getExpenseDetails();
    }

    @GetMapping("/getExpenseDetailsById")
    public ResponseEntity<List<DuesProjection>> getExpenseDetailsById(){
        return service.getExpenseDetailsById();
    }


    @GetMapping("/roommates")
    public ResponseEntity<List<User>> getRoommates(HttpSession session){
//        if(session.getAttribute("role").equals(0)){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        System.out.println("*********************");
//        System.out.println(session.getAttribute("userid"));
//        System.out.println(session.getAttribute("role"));
//        System.out.println(session.getAttribute("name"));
        return service.getRoommates();
    }

}
