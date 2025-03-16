package com.security.security.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="roomexpensedetails")
public class ExpenseDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userid;
    private int expensetypeid;

    private Date billeddate;

    private double dueamount;

    private double amountpaid;

    public byte getForwardstatus() {
        return forwardstatus;
    }

    public void setForwardstatus(byte forwardstatus) {
        this.forwardstatus = forwardstatus;
    }

    public int getBalancedue() {
        return balancedue;
    }

    public void setBalancedue(int balancedue) {
        this.balancedue = balancedue;
    }

    private byte forwardstatus = 0 ;

    @Column(updatable = false,insertable = false)
    private int balancedue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getExpencetype() {
        return expensetypeid;
    }

    public void setExpencetype(int expensetypeid) {
        this.expensetypeid = expensetypeid;
    }

    public Date getBilleddate() {
        return billeddate;
    }

    public void setBilleddate(Date billeddate) {
        this.billeddate = billeddate;
    }

    public double getDueamount() {
        return dueamount;
    }

    public void setDueamount(double dueamount) {
        this.dueamount = dueamount;
    }

    public double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public byte getPaidstatus() {
        return paidstatus;
    }

    public void setPaidstatus(byte paidstatus) {
        this.paidstatus = paidstatus;
    }

    public Date getPaiddate() {
        return paiddate;
    }

    public void setPaiddate(Date paiddate) {
        this.paiddate = paiddate;
    }

    public ExpenseDetailsEntity() {
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;

    public ExpenseDetailsEntity(String remarks ,int id, int userid, int expensetypeid, Date billeddate, double dueamount, double amountpaid, byte paidstatus, Date paiddate) {
        this.id = id;
        this.userid = userid;
        this.expensetypeid = expensetypeid;
        this.billeddate = billeddate;
        this.dueamount = dueamount;
        this.amountpaid = amountpaid;
        this.paidstatus = paidstatus;
        this.paiddate = paiddate;
        this.remarks = remarks;
    }

    @Column(updatable = false,insertable = false)
    private byte paidstatus;
    private Date paiddate;

}
