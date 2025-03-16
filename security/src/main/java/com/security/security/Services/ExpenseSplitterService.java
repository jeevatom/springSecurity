package com.security.security.Services;

import com.security.security.Dto.ExpenseDetailsDto;
import com.security.security.Models.ExpenseDetailsEntity;
import com.security.security.Repository.ExpenseSploitterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExpenseSplitterService {

    @Autowired
    ExpenseSploitterRepo repo;

    public ResponseEntity<String> SplitExpensesService(ExpenseDetailsDto expenseDatas) {
        try {
            int[] roommates = expenseDatas.getUserid();
            int roommateslength = expenseDatas.getUserid().length;
            double dueAmount = expenseDatas.getDueamount() / roommateslength;
            Date dateofbill = expenseDatas.getBilleddate();
            int expensetype = expenseDatas.getExpencetype();
            String remarks = expenseDatas.getRemarks();
            for (int i = 0; i < roommateslength; i++) {
                ExpenseDetailsEntity entity = new ExpenseDetailsEntity();
                entity.setDueamount(dueAmount);
                entity.setBilleddate(dateofbill);
                entity.setExpencetype(expensetype);
                entity.setRemarks(remarks);
                entity.setPaidstatus((byte) 0);
                entity.setAmountpaid(0);
                entity.setUserid(roommates[i]);
                repo.save(entity);
            }
        }catch (Exception e){
            System.out.println("Exception in splitting "+e);
            return new ResponseEntity<>("split error", HttpStatus.OK);
        }
     return new ResponseEntity<>("split Successfully", HttpStatus.CREATED);
    }
}
