package com.nerdysoft.task.services;

import com.nerdysoft.task.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    void save(User user);

    User findUserByUsername(String username);

    User findById(int id);
}
