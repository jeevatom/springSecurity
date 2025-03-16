package com.security.security.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class ExpenseDetailsDto {

    private int id;
    private int [] userid;
    private int expencetype;

    private Date billeddate;

    private double dueamount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int [] getUserid() {
        return userid;
    }

    public void setUserid(int [] userid) {
        this.userid = userid;
    }

    public int getExpencetype() {
        return expencetype;
    }

    public void setExpencetype(int expencetype) {
        this.expencetype = expencetype;
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

    public ExpenseDetailsDto() {
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;

    public ExpenseDetailsDto(String remarks ,int id,  int expencetype, Date billeddate, double dueamount, byte paidstatus, Date paiddate) {
        this.id = id;
        this.expencetype = expencetype;
        this.billeddate = billeddate;
        this.dueamount = dueamount;
        this.paidstatus = paidstatus;
        this.paiddate = paiddate;
        this.remarks = remarks;
    }

    private byte paidstatus;
    private Date paiddate;

}
