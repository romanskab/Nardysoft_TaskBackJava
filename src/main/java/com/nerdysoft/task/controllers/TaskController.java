package com.nerdysoft.task.controllers;

import com.nerdysoft.task.models.CustomResponse;
import com.nerdysoft.task.models.Task;
import com.nerdysoft.task.models.User;
import com.nerdysoft.task.models.UsersTasks;
import com.nerdysoft.task.services.TaskService;
import com.nerdysoft.task.services.UserService;
import com.nerdysoft.task.services.UsersTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    UsersTasksService usersTasksService;

    @PostMapping("/task/create")
    public CustomResponse create(@RequestBody Task task) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);
        taskService.save(task);
        Task task1 = taskService.findByDescription(task.getDescription());
        usersTasksService.save(new UsersTasks(user, task1));
        return new CustomResponse("/task/create ok!", true);
    }

    @GetMapping("/task/user/{userId}")
    public List<Task> getAllByUserId(@PathVariable int userId) {
        List<UsersTasks> usersTasksList = usersTasksService.findAllByUserId(userId);
        List<Task> tasks = new ArrayList<>();
        for (UsersTasks usersTasks : usersTasksList) {
            Task task = taskService.findById(usersTasks.getTask().getId());
            tasks.add(task);
        }
        return tasks;
    }

    @DeleteMapping("/task/delete/{taskId}")
    public CustomResponse delete(@PathVariable int taskId) {
        taskService.delete(taskId);
        return new CustomResponse("/task/delete ok!", true);
    }

    @PostMapping("/task/save")
    public CustomResponse save(@RequestBody Task task) {
        Task taskFromService = taskService.findById(task.getId());
        taskFromService.setDescription(task.getDescription());
        taskService.save(taskFromService);
        return new CustomResponse("/task/save ok!", true);
    }

    @PostMapping("/task/share/{taskId}/{email}")
    public CustomResponse share(@PathVariable int taskId, @PathVariable String email) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User sender = userService.findUserByUsername(username);
        Task task = taskService.findById(taskId);
        User user = userService.findUserByUsername(email);
        if (user == null) {
            throw new Exception("No recipient found!!!");
        }
        task.setSenderEmail(sender.getUsername());
        taskService.save(task);

        Boolean isRelationship = false;
        List<UsersTasks> allByUser = usersTasksService.findAllByUser(user);
        for (UsersTasks usersTasks : allByUser) {
            if (usersTasks.getTask().equals(task)) {
                isRelationship = true;
            }
        }
        if (!isRelationship) {
            usersTasksService.save(new UsersTasks(user, task));
        }
        return new CustomResponse("/task/share ok!", true);
    }

}
