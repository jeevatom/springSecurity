package com.security.security.Services;

import com.security.security.Models.User;
import com.security.security.Models.UserPrincipal;
import com.security.security.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserdetailsService implements UserDetailsService {

    @Autowired
    private userRepo repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user=repo.findByUserName(userName);

       if(user==null){
           System.out.println("User not Found");
           throw new UsernameNotFoundException("not found");
       }

        return new UserPrincipal(user);
    }
}
