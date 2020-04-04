package com.nerdysoft.task.services;

import com.nerdysoft.task.models.Task;
import org.springframework.stereotype.Service;


@Service
public interface TaskService {
    void save(Task task);

    Task findById(int id);

    Task findByDescription(String description);

    void delete(int id);
}
