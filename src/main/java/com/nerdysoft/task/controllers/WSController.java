package com.nerdysoft.task.controllers;

import com.nerdysoft.task.models.Task;
import com.nerdysoft.task.models.User;
import com.nerdysoft.task.models.ws.Message;
import com.nerdysoft.task.services.UserService;
import com.nerdysoft.task.services.UsersTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {
    @Autowired
    private UserService userService;

    @Autowired
    UsersTasksService usersTasksService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/hi")
    public Task taskOut(Message message) throws Exception{
        User sender = userService.findById(message.getSenderId());
        Task task = new Task(message.getTaskId(), message.getDescription(), sender.getUsername(), null);
        return task;
    }

}
