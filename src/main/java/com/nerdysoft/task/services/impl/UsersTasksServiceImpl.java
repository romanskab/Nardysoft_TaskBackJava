package com.nerdysoft.task.services.impl;

import com.nerdysoft.task.dao.UsersTasksDAO;
import com.nerdysoft.task.models.User;
import com.nerdysoft.task.models.UsersTasks;
import com.nerdysoft.task.services.UsersTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTasksServiceImpl implements UsersTasksService {
    @Autowired
    UsersTasksDAO usersTasksDAO;

    @Override
    public void save(UsersTasks usersTasks) {
        usersTasksDAO.save(usersTasks);
    }

    @Override
    public List<UsersTasks> findAllByUserId(int userId) {
        return usersTasksDAO.findAllByUserId(userId);
    }

    @Override
    public List<UsersTasks> findAllByUser(User user) {
        return usersTasksDAO.findAllByUser(user);
    }
}
