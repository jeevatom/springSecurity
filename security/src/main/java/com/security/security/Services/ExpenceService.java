package com.security.security.Services;

import com.security.security.Dto.DuesProjection;
import com.security.security.Models.ExpenseDetailsEntity;
import com.security.security.Models.ExpenseTypesEntity;
import com.security.security.Models.User;
import com.security.security.Repository.ExpenseSploitterRepo;
import com.security.security.Repository.ExpenseTypeRepo;
import com.security.security.Repository.userRepo;
import com.security.security.Util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenceService {
    @Autowired
    ExpenseTypeRepo repo;
    @Autowired
    ExpenseSploitterRepo expenserepo;
    @Autowired
    userRepo userrepo;


    public ResponseEntity<List<ExpenseTypesEntity>> getExpenseTypeDetails() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getRoommates() {
        return new ResponseEntity<>( userrepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<ExpenseDetailsEntity>> getExpenseDetails() {
        return new ResponseEntity<>( expenserepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<DuesProjection>> getExpenseDetailsById() {
        int id = UserUtil.getLoggedInUserId();
        return new ResponseEntity<>( expenserepo.findByUseId(id), HttpStatus.OK);
    }
}
