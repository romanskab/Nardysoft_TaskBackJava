package com.nerdysoft.task.services.impl;

import com.nerdysoft.task.dao.UserDAO;
import com.nerdysoft.task.models.User;
import com.nerdysoft.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public void save(User user) {
        if (user != null){
            userDAO.save(user);
        }
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id).get();
    }
}
