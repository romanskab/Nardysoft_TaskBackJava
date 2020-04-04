package com.nerdysoft.task.services;

import com.nerdysoft.task.models.User;
import com.nerdysoft.task.models.UsersTasks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersTasksService {
    void save(UsersTasks usersTasks);

    List<UsersTasks> findAllByUserId(int userId);

    List<UsersTasks> findAllByUser(User user);

}
