package com.nerdysoft.task.dao;

import com.nerdysoft.task.models.User;
import com.nerdysoft.task.models.UsersTasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersTasksDAO extends JpaRepository<UsersTasks, Integer> {
    List<UsersTasks> findAllByUserId(int userId);

    List<UsersTasks> findAllByUser(User user);


}
