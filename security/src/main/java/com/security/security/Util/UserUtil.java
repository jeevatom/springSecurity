package com.security.security.Util;

import com.security.security.Models.User;
import com.security.security.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    private static userRepo userRepository;

    @Autowired
    public UserUtil(userRepo userRepository) {
        UserUtil.userRepository = userRepository;
    }

    public static int getLoggedInUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername(); // Extract username
            User user = userRepository.findByUsername(username); // Fetch user from DB
            return user.getUserid();
        }
        return 0;
}
}