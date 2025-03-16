package com.security.security.Repository;


import com.security.security.Models.ExpenseTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepo extends JpaRepository<ExpenseTypesEntity,Integer> {

}
