package com.lyczkul.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lyczkul.security.model.User;

import javax.persistence.*;

/**
 * Created by Tomek on 11.06.2017.
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "task")
    @JsonBackReference(value = "task_comment")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference(value = "comment_user")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
