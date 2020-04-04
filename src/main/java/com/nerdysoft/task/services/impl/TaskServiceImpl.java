package com.nerdysoft.task.services.impl;

import com.nerdysoft.task.dao.TaskDAO;
import com.nerdysoft.task.models.Task;
import com.nerdysoft.task.models.UsersTasks;
import com.nerdysoft.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDAO taskDAO;

    @Override
    public void save(Task task) {
        if (task != null){
            taskDAO.save(task);
        }
    }

    @Override
    public Task findById(int id) {
        return taskDAO.findById(id);
    }

    @Override
    @Transactional
    public Task findByDescription(String description) {
        return taskDAO.findByDescription(description);
    }

    @Override
    public void delete(int id) {
        taskDAO.deleteById(id);
    }
}
