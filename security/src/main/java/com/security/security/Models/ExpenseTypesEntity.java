package com.security.security.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "expensetypes")
public class ExpenseTypesEntity {
    public ExpenseTypesEntity(int expenseTypeId, String expenseTypeDescription) {
        this.expenseTypeId = expenseTypeId;
        this.expenseTypeDescription = expenseTypeDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expensetypeid")
    private int expenseTypeId;

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseTypeDescription() {
        return expenseTypeDescription;
    }

    public void setExpenseTypeDescription(String expenseTypeDescription) {
        this.expenseTypeDescription = expenseTypeDescription;
    }

    @Column(name = "expensetypedesc")
    private String expenseTypeDescription;

    public ExpenseTypesEntity() {
    }
}
