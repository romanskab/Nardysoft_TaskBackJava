package com.nerdysoft.task.models.ws;

public class Message {
    private int taskId;
    private String description;
    private int senderId;
    private String email;

    public Message() {
    }

    public Message(int taskId, String description, int senderId, String email) {
        this.taskId = taskId;
        this.description = description;
        this.senderId = senderId;
        this.email = email;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Message{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", senderId=" + senderId +
                ", email='" + email + '\'' +
                '}';
    }
}
