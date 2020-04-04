package com.nerdysoft.task.dao;

import com.nerdysoft.task.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
