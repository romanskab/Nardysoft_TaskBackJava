package com.nerdysoft.task.dao;

import com.nerdysoft.task.models.Task;
import com.nerdysoft.task.models.UsersTasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Integer> {
    List<Task> findAllByUsersTasksContains(UsersTasks usersTasks);

    @Override
    void deleteById(Integer id);

    Task findByDescription(String description);

    Task findById(int id);
}
