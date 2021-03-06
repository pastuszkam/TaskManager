package com.lyczkul.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lyczkul.security.model.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tomek on 09.06.2017.
 */
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "project")
    @JsonBackReference(value = "project_task")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference(value = "task_user")
    private User user;

    @OneToMany(targetEntity = Comment.class, mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "task_comment")
    private Set<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
