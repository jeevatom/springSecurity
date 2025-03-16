package com.security.security.Controllers;

import com.security.security.Dto.ExpenseDetailsDto;
import com.security.security.Services.ExpenseSplitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class ExpenseSplitter {

    @Autowired
    ExpenseSplitterService service;

    @PostMapping("/expenseSplitter")
    public ResponseEntity<String> SplitExpenses(@RequestBody ExpenseDetailsDto ExpenseDatas){

        return service.SplitExpensesService(ExpenseDatas);
    }

}
