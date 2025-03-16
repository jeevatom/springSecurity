package com.security.security.Repository;


import com.security.security.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
