package com.security.security.Repository;

import com.security.security.Dto.DuesProjection;
import com.security.security.Models.ExpenseDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface ExpenseSploitterRepo extends JpaRepository<ExpenseDetailsEntity , Integer> {


    @Query(value = "SELECT ED.id, E.expensetypedesc AS duedesc, to_char(ED.billeddate,'dd-mm-yyyy') as billeddate,ED.remarks,ED.dueamount, " +
            "ED.amountpaid, " +
            "CASE WHEN ED.paidstatus = 0 THEN 'PENDING' " +
            "WHEN ED.paidstatus = 1 THEN 'PARTIALLY PAID' ELSE 'FULLY PAID' END AS billedStatus " +
            "FROM roomexpensedetails ED " +
            "JOIN expensetypes E ON E.expensetypeid = ED.expensetypeid " +
            "JOIN roommates U ON U.userid = ED.userid " +
            "WHERE ED.paidstatus IN (0,1) AND U.userid = :userid",
            nativeQuery = true)
    List<DuesProjection> findByUseId(@Param("userid") int id);

}
